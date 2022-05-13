package com.kh.ex01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ex01.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 글쓰기 폼
	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public String createForm() {
		return "board/create_form";
	}
	
	// 글등록
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String createRun(BoardVo boardVo) {
		System.out.println("BoardController, createRun, boardVo:" + boardVo);
		return "redirect:/board/list";
	};
	
	// 조회
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(int bno) {
		System.out.println("BoardController, read, bno: " + bno);
		return "board/read";
	}
	
	// 수정 폼
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update_form";
	}
	
	// 수정 처리
	@RequestMapping(value = "/updateRun", method = RequestMethod.POST)
	public String updateRun(BoardVo boardVo) {
		System.out.println("BoardController, updateRun, boardVo:" + boardVo);
		return "redirect:/board/read";
	}
	
	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno) {
		return "redirect:/board/list";
	}
	
	// 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "board/list";
	}
}
