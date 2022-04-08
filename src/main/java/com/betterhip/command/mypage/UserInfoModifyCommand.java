package com.betterhip.command.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.mypage.UserInfoDao;

public class UserInfoModifyCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//사용자 아이디 겟파라미터로 받을 때 
		String USER_ID = request.getParameter("user_id");
				
		//사용자 아이디 세션으로 받을 때 
//		HttpSession session = request.getSession();
//		String USER_ID = (String) session.getAttribute("USER_ID"); 

		//사용자가 수정하고자 하는 데이터 받아오기 
		String new_user_pw = request.getParameter("new_user_pw");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone = request.getParameter("user_phone");
		String user_postcode = request.getParameter("user_postcode");
		String user_address = request.getParameter("user_address");
		String user_address_detail = request.getParameter("user_address_detail");
		
		//회원 정보 수정 
		UserInfoDao dao = new UserInfoDao();
		dao.userInfoModify(USER_ID, new_user_pw, user_name, user_email, user_phone, user_postcode, user_address, user_address_detail);
		
		
		
		
		
		
	}

}
