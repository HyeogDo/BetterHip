package com.betterhip.command.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.mypage.UserInfoDao;

public class UserInfoDeleteCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String USER_ID = (String) session.getAttribute("USER_ID"); 
		UserInfoDao dao = new UserInfoDao();
		dao.userInfoDelete(USER_ID);
		
		
		

		
	}//execute 

}//userinfodeletecommand 
