package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.BoardService;
import com.example.vo.Board;

// Controller : 사용자로 부터 입력받고, 데이터(Model)과 뷰를 연결
// 서버는 컨트롤러를 주소(url)로 구별
//		주소가 같은 컨트롤러가 있는 경우 서버는 죽는다
//		주소를 지정하는 어노테이션 : @WebServlet

// 컨트롤러를 만들 때
// 		GET : jsp를 forward(request 객체가 이어진다)
//		POST : 다른 서블릿으로 redirect(request 파괴. 새로운 request)

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> list = BoardService.getInstance().list();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}
}








