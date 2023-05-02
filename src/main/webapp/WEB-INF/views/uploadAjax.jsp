<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 7.오전 10:35:24</title>
<link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<style>
  .bigPictureWapper {
  position: absolute;
  display: none;
  justify-content:center;
  align-items:center;
  top:0;
  widhth:100%;
  height: 100%;
  background-color: gray;
  z-index: 100;
  background: rgba(0,0,0,0.5);
  }
  .bigPicture {
  position: relative;
  display: flex;
  justify-content:center;
  align-items:center;
  }
  .bigPicture img{
  width:  600px;
  }
</style>
</head>
<body>
<form method="post" enctype="multipart/form-data">
      <!-- <input name="test"> -->
      <label for="files"><i class="fas fa-folder-plus"></i></label>
      <input type="file" name="files" multiple id="files" > <!--accept="image/jpeg, image/png"   -->
      <input type="reset" value="reset"/>
      <button>submit</button>     
      <div></div>

</form>
<div class="uploadResult">
   <ul>
   </ul>
</div>
<div class="bigPictureWapper">
   <div class="bigPicture">
   </div>
</div>
<script>
	
	
$(function(){
	 $(".bigPictureWapper").click(function(){
		 $(".bigPicture").animate({width: 0, height:0}, 1000);
		 setTimeout(function(){
			 $(".bigPictureWapper").hide();
		 },1000);
	 })
	 function checkExtension(files){
		 const MAX_SIZE = 5 * 1024 * 1024;
		 const EXCLUDE_EXT = new RegExp("(.*?)\.(js|jsp|asp|php)");
		 
		 for(let i in files){
			 if(files[i].size >= MAX_SIZE || EXCLUDE_EXT.test(files[i].name)){
			 alert("조건 불일치");
				 return false;
			 }
		 }
		 return true;
	 }
	 $(".uploadResult ul").on("click", ".img-thumb", function(){
		 event.preventDefault();	 
		 $(".bigPictureWapper").css("display", "flex").show();
		 var param = $(this).find("img").data("src")
	 	$(".bigPicture")
		.html("<img src='/display?" + param + "'>")
		.animate({width:'100%', height:'100%'}, 1000); 
	 }); 
	 $(".uploadResult ul").on("click", ".btn-remove", function(){
		 event.preventDefault();
		var file = $(this).data("file");
		 $.get("/deleteFile?" + file).done(function(data) {
				 console.log(data);
		 });
	 });
	 
	 /* $("form :file").change(function(){
		 let str ="";	 
		for(let i = 0; i < this.files.length; i++) {
			str += "<p> ========================</p>";
			str += "<p>" + this.files[i].name + "</p>";
			str += "<p>" + this.files[i].type + "</p>";
			str += "<p>" + this.files[i].size + "</p>";
			
		}
		$("form div").html(str);
	 }) */
	 function showUploadFile(uploadResultArr){
		 var str = "";
		/*  $(uploadResultArr).each(function(i,item){
			 str += "<li>" + item.name + "<li>"
		 }) */
		 
		 for(var i in uploadResultArr){
			 let obj =  uploadResultArr[i];
			 obj.thumb = "on";
			 var params = new URLSearchParams(obj).toString();
			 if(!obj.image){
			 str += '<li><a href="/download?' + params + '"><i class="far fa-file"></i>';
				 
			 }
			 else {
			//	 console.log(uploadResultArr[i]);
				
				 obj.thumb = "off";
			 var params2 = new URLSearchParams(obj).toString();
				str += '<li><a class="img-thumb" href=""><img src="/display?' + params + '"data-src="' + params2 + '" >';
			 }//javascript:showImage(\''+ params2 +'\')
			 str += obj.name + '</a><i class="far fa-times-circle btn-remove" data-file="' + params + '"></i></li>';
		 }
	//	console.log(str)
	
	//내부스트림으로 사용
		 $(".uploadResult ul").append(str);
	 }
	 
	 $("form button").click(function(){
		 event.preventDefault();
		 let files = $(":file").get(0).files;
		// console.log(files);
		 if(!checkExtension(files)){
			 alert("조건불일치");
			 return false;
		 }
		 let formData = new FormData();
		 
		 for(let i in files){
			 formData.append("files", files[i]);
			 
		 }
		 
		 $.ajax({
			 url : "/uploadAjax",
			 processData : false,
			 contentType : false,
			 data : formData,
			 method : "post",
			 success : function(data){
			//	 console.log(data);
				 $("form").get(0).reset();
				 showUploadFile(data);
			 }
		 })
	 })
})
</script>

</body>
</html>