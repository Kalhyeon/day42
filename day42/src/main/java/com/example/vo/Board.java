package com.example.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Value Object : 사용자가 입력한 값을 담을 클래스 (Command 패턴, Command 객체)

// 어노테이션 : 내가 원하는 것을 작성하는 것이 아닌 요청한다 => 프레임워크가 해준다
// 어노테이션은 클래스, 필드, 메소드에 지정한다
// Lombok을 쓰면 이름을 바꿔도 에러가 안뜬다

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