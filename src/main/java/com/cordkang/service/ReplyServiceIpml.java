package com.cordkang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cordkang.domain.ReplyVO;
import com.cordkang.mapper.BoardMapper;
import com.cordkang.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ReplyServiceIpml implements ReplyService{
	private BoardMapper boardMapper;
	private ReplyMapper replyMapper;

	@Override
	public int register(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		boardMapper.updateReplyCnt(get(rno).getBno(), -1);
		return replyMapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Long bno, Long rno) {
		// TODO Auto-generated method stub
		return replyMapper.getList(bno, rno);
	}
	

}
