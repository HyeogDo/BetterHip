package com.betterhip.command.mypage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.mypage.UserInfoViewDao;
import com.betterhip.dto.mypage.UserInfoDto;


public class UserInfoModifyViewCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String LoginId = (String) session.getAttribute("LoginId"); 
		
//		String LoginId = request.getParameter("user_id");
		UserInfoViewDao dao = new UserInfoViewDao();
		UserInfoDto dto = dao.userInfoModifyView(LoginId); 
		request.setAttribute("userInfo", dto);
		
		
	}

}
