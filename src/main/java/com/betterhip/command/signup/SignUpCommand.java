package com.betterhip.command.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.signup.SignUpDao;

public class SignUpCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String user_id = request.getParameter("user_id");
		
		SignUpDao dao = new SignUpDao();
		dao.signup(user_id);
	}

}
