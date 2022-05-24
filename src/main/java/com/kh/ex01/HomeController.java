package com.kh.ex01;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ex01.service.MemberService;
import com.kh.ex01.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	// http://localhost/ex01/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		String userid = "user01";
		MemberVo loginVo = memberService.getMemberById(userid);
		session.setAttribute("loginVo", loginVo);
		return "home";
	}
	
}
