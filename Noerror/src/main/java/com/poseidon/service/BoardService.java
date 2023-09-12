package com.poseidon.service;

import org.springframework.data.domain.Page;

import com.poseidon.entity.Board;

public interface BoardService {
	
	Board save(Board board);

	//List<Board> list(int pageNo);
	//Page list();

	Page<Board> list(int pageNo);

	Board detail(int bno);
}
