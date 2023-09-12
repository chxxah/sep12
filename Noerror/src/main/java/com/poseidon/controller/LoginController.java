package com.poseidon.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poseidon.entity.Member;
import com.poseidon.service.LoginService;

@Controller
public class LoginController {

	@Resource(name = "loginService")
	private LoginService loginervice;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/join")
	public String join() {
		Member member = new Member();
		Member result = loginervice.join(member);
		System.out.println("가입결과 : " + result);
		return "redirect:/board";
	}
}
