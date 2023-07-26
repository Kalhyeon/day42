package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import com.example.vo.Board;

// Board로 CRUD하는 클래스 - 처리하는 클래스 => 객체를 하나만 만든다 => Singleton
// 디자인 패턴 : 자주 발생하는 문제에 대한 해답

public class BoardService {
//	 1. 자기 자신의 private final static 필드를 가진다
//	 	final : 변경금지
//		static : 공유한다
	private final static BoardService service = new BoardService();

//	2. private 생성자 => 외부에서 객체 생성 금지
	private BoardService() {
	}

	// 3. 외부에서 service 객체를 빌려가는 메소드를 추가
	public static BoardService getInstance() {
		return service;
	}

//	실제로는 오라클에 저장해야한다
	private ArrayList<Board> list = new ArrayList<>();
	private Long bno = 1L;

//	1. CURD 작업을 할 때 작업 대상을 구별하는 필드가 필요 => key => bno
//	2. Board 는 서비스에서 만들겠다
//	그러면 메소드의 매개변수는 키 또는 객체
//	글 추가 (제목, 내용, 닉네임, 비밀번호)
//	글 목록 ()
//	글 읽기 (bno)
//	글 변경 (bno, 제목, 내용, 비밀번호)
//	글 삭제 (bno, 비밀번호)

	public void create(String title, String content, String nickname, String password) {
//		암호화
//		hash => 암호를 걸고 비교할 수 있다.
//		하지만 해독은 불가능하다 (단방향 함수, 일방향 함수).
		
//		salt : 보안을 강화시키는 조미료 (랜덤을 의미)
		String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		Board board = new Board(bno++, title, content, LocalDate.now(), 0L, nickname, encodedPassword);
		list.add(board);
	}

	public ArrayList<Board> list() {
		return list;
	}
}