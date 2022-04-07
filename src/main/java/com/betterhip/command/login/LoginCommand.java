package com.betterhip.command.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.login.LoginDao;



public class LoginCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		// 아이디, 비밀번호 확인하여 message, viewPage 전달
		//  2 : 인증성공
		//  1 : 아이디 틀림
		// -1 : 비밀번호 틀림
		// -2 : 탈퇴회원
		//  0 : DB 연결안됨
		//  3 : 카카오톡 사용자가 회원등록 하지 않았거나 이메일 사용동의 등록하지 않음
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		String loginMethod = request.getParameter("loginMethod");
		String message = "";
		String viewPage = "";
		
		
		HttpSession session = request.getSession();	
	
		LoginDao dao = new LoginDao();
		int result = dao.Login(user_id, user_pw, loginMethod);
				
		switch(result) {
		case 2 :
			message = "success";
			viewPage = "main.do";
			session.setAttribute("user_id", user_id); // 로그인 성공 시 user_id 정보생성			
			break;
			
		case 1 :
			message = "아이디가 틀렸습니다";
			viewPage = "login/login.jsp";
			break;
		
		case 0 : 
			message = "데이터베이스 연결에 실패하였습니다";
			viewPage = "login/login.jsp";
			break;
			
		case -1 :
			message = "비밀번호가 틀렸습니다";
			viewPage = "login/login.jsp";
			break;
			
		case -2 :
			message = "탈퇴회원 입니다 재가입 해주세요";
			viewPage = "login/login.jsp";
			break;
			
		case -3 :
			message = "가입하지 않았거나 이메일 동의를 하지 않으셨습니다";
			viewPage = "login/login.jsp";
			break;
		}

		//System.out.println("result : " + result);
		//System.out.println("message : " + message);
		//System.out.println("viewPage : " + viewPage);
		
		request.setAttribute("viewPage", viewPage);
		request.setAttribute("message", message);	
		session.setAttribute("message", message);
			
	}

}
