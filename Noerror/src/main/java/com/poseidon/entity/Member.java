package com.poseidon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	
	@Column(unique = true)
	private String mname;
	
	@Column(unique = true)
	private String memail;
	
	private String mpw; 
	
	//가입일 
	@CreationTimestamp
	private LocalDateTime mdate = LocalDateTime.now();
	
	//등급 0탈퇴, 1차단 5정상 9관리자
	@ColumnDefault("5")
	private int grade; 
	
	
}
