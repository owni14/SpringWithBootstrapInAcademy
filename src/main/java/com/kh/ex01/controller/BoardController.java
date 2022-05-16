package com.kh.ex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.service.BoardService;
import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글쓰기 폼
	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public String createForm() {
		return "board/create_form";
	}
	
	// 글등록
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String createRun(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("BoardController, createRun, boardVo:" + boardVo);
		boolean result = boardService.create(boardVo);
		System.out.println("BoardController, createRun, result:" + result);
		rttr.addFlashAttribute("create_result", result);
		return "redirect:/board/list";
	};
	
	// 조회
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(int bno, Model model) {
		System.out.println("BoardController, read, bno: " + bno);
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
		return "board/read";
	}
	
	// 수정 폼
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update_form";
	}
	
	// 수정 처리
	@RequestMapping(value = "/updateRun", method = RequestMethod.POST)
	public String updateRun(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("BoardController, updateRun, boardVo:" + boardVo);
		boolean result = boardService.update(boardVo);
		rttr.addFlashAttribute("update_result", result);
		return "redirect:/board/read?bno=" + boardVo.getBno();
	}
	
	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno, RedirectAttributes rttr) {
		boolean result = boardService.delete(bno);
		rttr.addFlashAttribute("delete_result", result);
		return "redirect:/board/list";
	}
	
	// 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, int page) {
		PagingDto pagingDto = new PagingDto();
		pagingDto.setPage(page);
		List<BoardVo> boardList = boardService.list(pagingDto);
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
}
