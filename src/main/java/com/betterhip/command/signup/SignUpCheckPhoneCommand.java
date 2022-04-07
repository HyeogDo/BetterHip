package com.betterhip.command.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.signup.SignUpDao;
import com.betterhip.dto.signup.SignupCheckIdDto;
import com.mysql.cj.Session;

public class SignUpCheckPhoneCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String user_phone = request.getParameter("user_phone");
		
		SignUpDao dao = new SignUpDao();
		SignupCheckIdDto dto = dao.signupCheckId(user_id);
		HttpSession session = request.getSession();
		
		if (dto.getUser_id() == null) {
			session.setAttribute("RESULT", "Possible");
		} else {
			session.setAttribute("RESULT", "Impossible");
		}
		
		
	}

}