package com.betterhip.command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.cart.CartOrderDao;

public class CartOrderCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] orderList = request.getParameterValues("chk");
		CartOrderDao dao = new CartOrderDao();
		dao.cartOrder(orderList);
		
		

	}

}
