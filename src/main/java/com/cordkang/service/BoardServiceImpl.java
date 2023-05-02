package com.cordkang.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cordkang.controller.UploadController;
import com.cordkang.domain.AttachFileDTO;
import com.cordkang.domain.AttachVO;
import com.cordkang.domain.BoardVO;
import com.cordkang.domain.Criteria;
import com.cordkang.mapper.AttachMapper;
import com.cordkang.mapper.BoardMapper;
import com.cordkang.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@ToString
@Service   // 빈으로 등록할 목적
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
//	@Setter
//	@Autowired
	private final BoardMapper boardMapper;
	private final AttachMapper attachMapper;
	private ReplyMapper replyMapper;
//    private BoardService boardService;

	@Override
	@Transactional
	public void register(BoardVO vo) {
		boardMapper.insertSelectKey(vo);
		Long bno = vo.getBno();
		List<AttachVO> list = vo.getAttachs();
		int idx= 0;
		for(AttachVO attach : list){
			attach.setBno(bno);
			attach.setOrd(idx++);
			attachMapper.insert(attach);
		}
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		return boardMapper.read(bno);
	}

	@Override
	@Transactional
	public boolean modify(BoardVO vo) {
		attachMapper.deleteAll(vo.getBno());
		
		List<AttachVO> list = vo.getAttachs();
		int idx =0;
		for(AttachVO attach : list){
			attach.setBno(vo.getBno());
			attach.setOrd(idx++);
			attachMapper.insert(attach);
			
		}
		
		return boardMapper.update(vo) > 0;
	}

	@Override
	@Transactional
	public boolean remove(Long bno) {
		replyMapper.deleteByBno(bno);
		attachMapper.deleteAll(bno);
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCnt(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCnt(cri);
	}

	@Override
	 public String deleteFile(AttachFileDTO dto){
  	  log.info(dto);
  	//  File file2 = new File(file);
  	  String s = UploadController.getPATH() + "/" + dto.getPath() + "/" + dto.getUuid() + "_" + dto.getName();
  	  
  	  File file = new File(s);
  	  file.delete();
  	  if(dto.isImage()){
  		  s = UploadController.getPATH() + "/" + dto.getPath() + "/s_" + dto.getUuid() + "_" + dto.getName();
  		  file = new File(s);
  		  file.delete();
  	  }
  	  log.info(file);
  	  return dto.getUuid();
    }
	
	
	

}
