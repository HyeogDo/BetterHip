package com.betterhip.command.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.signup.SignUpDao;
import com.betterhip.dto.signup.SignupCheckPhoneDto;

public class SignUpCheckPhoneCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String user_phone = request.getParameter("user_phone");
		
		SignUpDao dao = new SignUpDao();
		SignupCheckPhoneDto dto = dao.signupCheckPhone(user_phone);
		HttpSession session = request.getSession();
		
		if (dto.getUser_phone() == null) {
			session.setAttribute("RESULT_PHONE", "Possible");
		} else {
			session.setAttribute("RESULT_PHONE", "Impossible");
		}
		
		
	}

}
