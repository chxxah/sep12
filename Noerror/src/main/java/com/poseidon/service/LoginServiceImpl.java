package com.poseidon.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.entity.Member;
import com.poseidon.repository.LoginReposeitory;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginReposeitory loginReposeitory;

	@Override
	public Member join(Member member) {
		member.setMname("포세이돈");
		member.setMemail("poseidon@kakao.com");
		member.setMpw("1");
		member.setMdate(LocalDateTime.now());
		return loginReposeitory.save(member);
	}


}
