package kr.kh.tmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.tmp.model.vo.MemberVO;
import kr.kh.tmp.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		if(memberservice.signup(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "회원가입 성공");
		}else {
			model.addAttribute("url", "/signup");
			model.addAttribute("msg", "회원가입 실패");			
		}
		return "message";
	}
	
}
