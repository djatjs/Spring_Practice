package kr.kh.tmp.controller;

import javax.servlet.http.HttpSession;

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
	public String signup(Model model, String id) {
		model.addAttribute("id", id);
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		if(memberservice.signup(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "회원가입 성공");
		}else {
			model.addAttribute("url", "/signup?id="+member.getMe_id());
			model.addAttribute("msg", "회원가입 실패");			
		}
		return "message";
	}
	
	@GetMapping("/login")
	public String login(Model model, String id) {
		model.addAttribute("id", id);
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberservice.login(member);
		if(user != null) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인 성공");
			model.addAttribute("user", user);
		}else {
			model.addAttribute("url", "/login?id="+member.getMe_id());
			model.addAttribute("msg", "로그인 실패");			
		}
		return "message";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, MemberVO user, HttpSession session) {
		session.removeAttribute("user");
		
		model.addAttribute("url", "/");
		model.addAttribute("msg","로그아웃했습니다");
		return "message";
	}
}
