package com.kh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.vo.ProductVo;

@Controller
public class SampleController2 {
	
	// /WEB-INF/views/반환값.jsp 로 포워드
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC() {
		System.out.println("doC 실행됨");
		return "result"; // /WEB-INF/views/result.jsp
	}
	
	// localhost/ex01/doD?message=Hello
	// localhost/ex01/doD?msg=Hi
	// @ModelAttribute("message")
	// -> message: 파라미터명
	// -> view까지 message라는 이름으로 사용
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(/*@ModelAttribute("message")*/ String msg) {
		// -> String msg = request.getParameter("message")
		// -> @ModelAttribute 생략시 뷰에 전달 안됨
		System.out.println("doD 실행됨");
		System.out.println("msg:" + msg);
		return "do_d";
	}
	
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public String doE(Model model) {
		// Model : 데이터 바구니 (request.setAttribute())
		ProductVo productVo = new ProductVo("아이폰", 1000000);
//		model.addAttribute("productVo", productVo);
		model.addAttribute(productVo);
		// -> 모델의 키를 생략하면 클래스명의 첫글자를 소문자로 바꾼 이름으로 사용됨
		return "do_e";
	}
	
	@RequestMapping(value ="/doF", method = RequestMethod.GET)
	public String doF() {
		System.out.println("doF 실행됨");
		return "redirect:/doE"; // 포워드 (x). 리다이렉트 (o)
	}
	
	@RequestMapping(value = "/doG", method = RequestMethod.GET)
	public String doG(RedirectAttributes rttr) {
		System.out.println("doG 실행됨");
		rttr.addFlashAttribute("message", "success");
		// -> session 넣고 -> 사용 -> 파기
		return "redirect:/doE";
	}
}
