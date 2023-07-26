package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import com.example.vo.Board;

// 클래스는 크게 다음과 같이 나뉜다
// 1. 값을 담고있는 클래스
//	  - 입력한 값을 담고있는 클래스(VO)
//	  - 클래스들 사이에서 값을 운반하는 클래스(DTO 나중에)
// 2. 값을 처리하는 클래스
//	  - 1번 객체를 DB에 입출력하는 클래스(Data Access Object 또는 Repository)
//	  - DAO를 이용해 작업을 처리하는 클래스(Service)
// 3. 사용자와 입출력하는 클래스(Controller)

// 값을 처리하는 클래스는 객체가 1개만 존재해야 한다
// 1. 어떻게하면 객체를 1개만 만들 수 있을까? 
//    이와같이 특정한 문제가 발생했을 때 어떻게 대처하세요...란 해결책은 design pattern이라고 한다
// 2. 객체를 1개만 만드는 디자인 패턴은 Singleton 패턴
// 3. 스프링 프레임워크을 사용하면 모든 처리하는 클래스의 객체는 싱글톤을 보장한다

// 싱글톤을 만드는 방법
// 1. 자신의 final static 필드
// 2. 생성자 private
// 3. 객체를 빌리는 getInstance()

public class BoardService {
	private final static BoardService service = new BoardService();
	private BoardService() { }
	public static BoardService getInstance() {
		return service;
	}
	
	// 데이터를 저장하는 작업은 DAO 클래스가 전담한다
	// 지금은 ArrayList로 DAO를 대체한다
	// 이렇게 프로그래밍을 진행하기 위해 사용하는 가짜 객체를 "mock 객체"라고 한다 
	private ArrayList<Board> dao = new ArrayList<>();
	// 글번호로 사용할 일련번호
	// 오라클에서는 sequence라고 하는데 DAO가 가짜다 보니 일반 변수로 진행하자
	private Long bno = 1L;
	
	public void create(String title, String content, String nickname, String password) {
		// 암호화 : 암호를 풀어 원래 데이터를 확인할 수 있다
		// hash : 암호를 풀 수 없는 단방향 함수. %10으로 해시한다면 1234%10->4
		String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		Board board = new Board(bno++, title, content, LocalDate.now(), 0L, nickname, encodedPassword);
		dao.add(board);
	}
	
	public ArrayList<Board> list() {
		return dao;
	}
	
}



































