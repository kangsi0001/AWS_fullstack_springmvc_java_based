package com.cordkang.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cordkang.domain.AttachVO;
import com.cordkang.domain.BoardVO;
import com.cordkang.domain.Criteria;
import com.cordkang.domain.PageDto;
import com.cordkang.domain.SampleVO;
import com.cordkang.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board/*")
//@AllArgsConstructor
@Data
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("list")
	public void list(Model model, Criteria cri){
		log.info("list()"); 
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("page", new PageDto(boardService.getTotalCnt(cri), cri));
	}
	@GetMapping({"get", "modify"})
	public void get(Model model, Long bno, @ModelAttribute("cri")Criteria cri){
		log.info("get() or modify()");
		log.info(bno);
		model.addAttribute("board", boardService.get(bno));
	}
	@GetMapping("{bno}")
	public String getByPath(Model model, @PathVariable Long bno){
		log.info("get() or modify()");
		log.info(bno);
		model.addAttribute("board", boardService.get(bno));
		return "board/get";
	}
	@GetMapping("register")
	@PreAuthorize("isAuthenticated()")
	public void register(){}
	
	@GetMapping("register2")
	public void register2(){}
	
	@PostMapping("register")
	public String register(BoardVO vo, RedirectAttributes rttr, Criteria cri){
		log.info("register");
		log.info(vo);
		boardService.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		rttr.addAttribute("pageNum", 1);
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:/board/list";
	//	return "redirect:/board/list" + cri.getFullQueryString();
	}
	@PreAuthorize("isAuthenticated() and principal.username eq #vo.writer")
	@PostMapping("modify")
	public String modify(BoardVO vo, RedirectAttributes rttr, Criteria cri){
		//원본 리스트
         List<AttachVO> originList =   boardService.get(vo.getBno()).getAttachs();
			
	//수정된 리스트
	      List<AttachVO> list = vo.getAttachs();
	      
		log.info("modify");
		log.info(vo);
		log.info(cri);
		if(boardService.modify(vo)) {
	    	rttr.addFlashAttribute("result", "success");
//	    	originList.stream().filter(v -> {
//	    		boolean flag = false;
//	    		for(AttachVO vo2 : list){
//	    			flag = vo2.getUuid().equals(v.getUuid());
//	    		}
//	    		return flag;
//	    	}).forEach(boardService::deleteFile);
		}

		return "redirect:/board/list" +cri.getFullQueryString();
	}
	@PreAuthorize("isAuthenticated() and principal.username eq #writer")
	@PostMapping("remove")
	public String remove(String writer, Long bno, RedirectAttributes rttr, Criteria cri){
		log.info("modify");
		log.info(bno);
		log.info(cri);
		List<AttachVO> list = boardService.get(bno).getAttachs();
		if(boardService.remove(bno)) {
//		list.forEach(boardService::deleteFile);
			for(AttachVO vo : list){
				boardService.deleteFile(vo);
			}
		rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list" + cri.getFullQueryString();
	}
	@GetMapping("getSample")
	@ResponseBody //반환에 관한것 
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}

}
