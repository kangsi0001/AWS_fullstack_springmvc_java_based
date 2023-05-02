package com.cordkang.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cordkang.domain.BoardVO;
import com.cordkang.domain.Criteria;
import com.cordkang.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void testCreate(){
		List<BoardVO> boards = boardMapper.getListWithPaging(new Criteria(1, 5));
		boards.forEach(log::info);
		
		IntStream.rangeClosed(1, 50).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			vo.setBno(boards.get(i%5).getBno());
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("tester" + i);
			
			replyMapper.insert(vo);
		});
	}
	
	
	@Test
	public void testRead(){
		Long rno= 5L;
		log.info(replyMapper.read(rno));
	}
	@Test
	public void testDelete(){
		Long rno= 2L;
		log.info(replyMapper.delete(rno));
	}
	@Test
	public void testUpdate(){
		ReplyVO vo = replyMapper.read(3L);
		vo.setReply("수정된 댓글내용");
		
		log.info(replyMapper.update(vo));
	}
	
	@Test
	public void testList(){
		replyMapper.getList(40971L, 0L).forEach(log::info);
	}
	

}
