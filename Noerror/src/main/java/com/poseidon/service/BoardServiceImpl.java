package com.poseidon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poseidon.entity.Board;
import com.poseidon.entity.Member;
import com.poseidon.repository.BoardReposeitory;
import com.poseidon.util.Util;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardReposeitory boardReposeitory;
	
	@Autowired
	private Util util;

	
	@Override
	public Board save(Board board) {
		Member member = new Member();
		member.setMno(1);
		board.setMember(member);
		board.setBip(util.getIP());
		return boardReposeitory.save(board);
	}


	@Override
	public Page<Board> list(int pageNo) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("bno"));
		Pageable pageable = PageRequest.of(pageNo - 1, 10, Sort.by(sorts));
		//Pageable pageable = PageRequest.of(pageNo - 1, 10);
		return boardReposeitory.findAll(pageable);
	}


	@Override
	public Board detail(int bno) {
		return boardReposeitory.findByBno(bno);
	}

}
