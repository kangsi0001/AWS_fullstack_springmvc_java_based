package com.cordkang.service;

import java.util.List;

import com.cordkang.domain.AttachFileDTO;
import com.cordkang.domain.BoardVO;
import com.cordkang.domain.Criteria;

public interface BoardService {
	void register(BoardVO vo);
	
	BoardVO get(Long bno);
	
	boolean modify(BoardVO vo);
	
	boolean remove(Long bno);
	
	public  List<BoardVO> getList(Criteria cri);
	
	int getTotalCnt(Criteria cri);
	
	String deleteFile(AttachFileDTO dto);

}
