package com.betterhip.command.mypage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.mypage.UserInfoViewDao;
import com.betterhip.dto.mypage.UserInfoDto;


public class UserInfoViewCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//겟파라미터로 받을 때 
		String USER_ID = request.getParameter("user_id");
		
		//세션에 넣기 
		HttpSession session = request.getSession();
		session.setAttribute("USER_ID", USER_ID);
		
		//세션으로 받을 때 
//		HttpSession session = request.getSession();
//		String USER_ID = (String) session.getAttribute("USER_ID"); 
		
		//회원정보 View 
		UserInfoViewDao dao = new UserInfoViewDao();
		UserInfoDto dto = dao.userInfoView(USER_ID); 
		request.setAttribute("userInfo", dto);
		
		
	}

}
