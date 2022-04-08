package com.betterhip.command.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.cart.CartListDao;
import com.betterhip.dto.cart.CartListDto;


public class CartListCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		CartListDao dao = new CartListDao();
		String  user_id = session.getAttribute("USER_ID").toString();
		ArrayList<CartListDto> dtos = dao.cartList(user_id);
		
		request.setAttribute("CartList", dtos);	

	}

}