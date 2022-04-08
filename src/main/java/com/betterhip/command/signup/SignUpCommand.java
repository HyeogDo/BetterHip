package com.betterhip.command.signup;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.signup.SignUpDao;

public class SignUpCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// signupForm.jsp에서 받아온 변수들 선언
		String user_id = request.getParameter("user_id");
		int user_pw = Integer.parseInt(request.getParameter("user_pw"));
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
		String user_postcode = request.getParameter("postcode");
		String user_address = request.getParameter("address1");
		String user_address_detail = request.getParameter("address2");
		String[] checkbox = request.getParameterValues("check");
		boolean user_marketing = true;
		if (checkbox.length == 2) {
			user_marketing = false;
		}
		// dao 생성 후 변수들 넘겨주기
		SignUpDao dao = new SignUpDao();
		dao.signup(user_id, user_pw, user_name, user_email, user_phone, user_postcode, user_address, user_address_detail, user_marketing);
	}

}
