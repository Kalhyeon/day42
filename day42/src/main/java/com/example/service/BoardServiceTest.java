package com.example.service;

import org.mindrot.jbcrypt.BCrypt;

public class BoardServiceTest {
	public static void main(String[] args) {
		String password = "12345678";
		
		String p1 = BCrypt.hashpw(password, BCrypt.gensalt());
		String p2 = BCrypt.hashpw(password, BCrypt.gensalt());
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
