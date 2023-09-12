package com.poseidon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.poseidon.entity.Board;

public interface BoardReposeitory extends PagingAndSortingRepository<Board, Long> {

	Page<Board> findAllByOrderByBnoDesc(Pageable pageable);

	Board save(Board board);

	Board findByBno(int bno);


}
