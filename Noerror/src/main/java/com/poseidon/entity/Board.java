package com.poseidon.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;

	// 코드
	@Column(columnDefinition = "LONGTEXT")
	private String code;

	// 글쓴 날
	@CreationTimestamp
	private LocalDateTime bdate = LocalDateTime.now();

	// 좋아요
	@ColumnDefault("1")
	private int blike;

	// 조회수
	@ColumnDefault("0")
	private int bread;

	// 글쓴이 조인하기
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mname")
	private Member member;
	
	//comment
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("id asc") // 댓글 정렬
	private List<Comment> commentLists;
	
	private String bip;
}
