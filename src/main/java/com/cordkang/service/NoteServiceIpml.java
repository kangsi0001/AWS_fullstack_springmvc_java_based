package com.cordkang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cordkang.domain.NoteVO;
import com.cordkang.mapper.NoteMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteServiceIpml implements NoteService {
	private NoteMapper mapper;

	@Override
	public int send(NoteVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	@Override
	public NoteVO get(Long noteno) {
		// TODO Auto-generated method stub
		return mapper.selectOne(noteno);
	}

	@Override
	public int receive(Long noteno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Long noteno) {
		// TODO Auto-generated method stub
		return mapper.delete(noteno);
	}

	@Override
	public List<NoteVO> getSendList(String id) {
		// TODO Auto-generated method stub
		return mapper.sendList(id);
	}

	@Override
	public List<NoteVO> getReceiveList(String id) {
		// TODO Auto-generated method stub
		return mapper.receiverList(id);
	}

	@Override
	public List<NoteVO> getReceiveUnchekedList(String id) {
		// TODO Auto-generated method stub
		return mapper.receiveUncheckedList(id);
	}
	

}
