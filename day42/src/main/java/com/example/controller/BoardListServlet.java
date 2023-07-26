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

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> list = BoardService.getInstance().list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
		
	}

}
