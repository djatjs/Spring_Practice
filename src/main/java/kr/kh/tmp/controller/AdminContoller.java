package kr.kh.tmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.kh.tmp.service.PostService;

@Controller
public class AdminContoller {
	@Autowired
	private PostService postService;
}
