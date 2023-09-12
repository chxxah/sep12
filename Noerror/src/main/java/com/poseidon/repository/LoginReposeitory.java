package com.poseidon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poseidon.entity.Member;

public interface LoginReposeitory extends JpaRepository<Member, Long> {


}
