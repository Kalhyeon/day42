package com.example.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Value Object : 사용자가 입력한 값을 담을 Command 클래스

@AllArgsConstructor
@Getter
public class Board {
	private Long bno;
	@Setter
	private String title;
	@Setter
	private String content;
	private LocalDate writeday;
	@Setter
	private Long readcnt;
	private String nickname;
	private String password;
}
