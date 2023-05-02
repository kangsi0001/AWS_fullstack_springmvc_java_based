//package com.cordkang.mapper;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.cordkang.domain.MemberVO;
//import com.cordkang.domain.NoteVO;
//
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
//public class NoteMapperTests {
//	@Autowired
//	private NoteMapper mapper;
//	@Autowired
//	private MemberMapper memberMapper;
//	
//	@Test
//	public void testInsert2(){
//		List<MemberVO> members = memberMapper.getList();
//		int i =1;
//		for(MemberVO vo : members){
//			for(MemberVO vo2 : members){
//				NoteVO noteVO = new NoteVO();
//				noteVO.setSender(vo.getId());
//				noteVO.setReceiver(vo.getId());
//				noteVO.setMessage("mapper 테스트발송 :: " + i++);
//				mapper.insert(noteVO);
//			}
//		}
//	}
//	
//	
//	@Test
//	public void testInsert(){
//		NoteVO noteVO = new NoteVO();
//		noteVO.setSender("id1");
//		noteVO.setReceiver("id3");
//		noteVO.setMessage("mapper 테스트발송");
//		
//		mapper.insert(noteVO);
//		
//	}
//	@Test
//	public void testSelectOne(){
//		log.info(mapper.selectOne(77L));
//	}
//	@Test
//	public void testUpdate(){
//		mapper.update(77L);
//	}
//	@Test
//	public void testDelete(){
//		mapper.delete(76L);
//	}
//	
//	@Test
//	public void testReceivechekedList(){
//		mapper.receiveUncheckedList("id1").forEach(log::info);
//	}
//	
//	
//	
//
//}
