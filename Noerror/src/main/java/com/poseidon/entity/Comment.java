package com.poseidon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	
	// board 조인하기
	@ManyToOne
	@JoinColumn(name = "bno")
	private Board board;
	
	// 글쓴이 조인하기
	@ManyToOne
	@JoinColumn(name = "mname")
	private Member member;

	// 코드
	@Column(columnDefinition = "TEXT", nullable = false)
	private String comment;

	// 글쓴 날
	@Column(name = "created_date")
	private LocalDateTime cdate;

	// 좋아요
	@ColumnDefault("1")
	private int clike;


}
