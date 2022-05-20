package com.kh.ex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.ex01.service.CommentService;
import com.kh.ex01.vo.CommentVo;

// 모든 메서드에 @ResponseBody가 자동으로 붙어 있다.
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello";
	}
	
	@RequestMapping(value = "/insertComment", method = RequestMethod.POST)
	public String insertComment(CommentVo commentVo) {
		boolean result = commentService.insertComment(commentVo);
		return String.valueOf(result);
	}
	
	@RequestMapping(value = "/commentList/{bno}", method = RequestMethod.GET)
	public List<CommentVo> commentList(@PathVariable("bno") int bno) {
		List<CommentVo> commentList = commentService.commentList(bno);
		return commentList;
	}
	
	@RequestMapping(value = "/deleteComment/{cno}", method = RequestMethod.GET)
	public String deleteComment(@PathVariable("cno") int cno) {
		boolean result = commentService.deleteComment(cno);
		return String.valueOf(result);
	}
	
	@RequestMapping(value = "/updateComment", method = RequestMethod.POST)
	public String updateComment(CommentVo commentVo) {
		System.out.println(commentVo);
		boolean result = commentService.updateComment(commentVo);
		System.out.println("result:" + result);
		return String.valueOf(result);
	}
	
}
