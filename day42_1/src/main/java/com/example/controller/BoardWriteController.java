package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.BoardService;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		
		// 만약 값을 입력하지 않거나 잘못된 값(비밀번호가 한글....)을 입력한다면 어떻게 하지
		// 일단 넘어가는데...나중에 처리해야한다
		
		BoardService.getInstance().create(title, content, nickname, password);
		response.sendRedirect("/day42/board/list");
		
		/*
		 * redirect하는 경우 아래처럼 작성하면 오류 발생
		 * if(a>10)
		 * 	  response.sendRedirect("/a");
		 * response.sendRedirect("/b");
		 * 
		 * if(a>10) {
		 * 		response.sendRedirect("/정상처리페이지");
		 * } else {
		 * 		response.sendRedirect("/입력오류페이지");
		 * }
		 * 
		 *
		 */
		
	}
}













