//package com.cordkang.mapper;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.cordkang.domain.MemberVO;
//
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
//public class MemberMapperTests {
//	@Autowired
//	private MemberMapper Mapper; 
//	
//	@Test
//	public void testGetList(){
//		Mapper.getList().forEach(log::info);
//	}
//    @Test
//    public void testLogin(){
//    	MemberVO vo = new MemberVO();
//    	vo.setId("id");
//    	vo.setPw("1234");
//    	log.info(Mapper.login(vo));
//    }
//}
