package com.betterhip.command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.cart.CartOrderDao;

public class CartOrderCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] orderList = request.getParameterValues("chk");
		CartOrderDao dao = new CartOrderDao();
		String orderResult = dao.cartOrder(orderList);
		String viewPage = "";
		
		switch(orderResult) {
		
		case("success") :
			viewPage = "paymentList.do";
			break;
		
		case("fail") :
			viewPage = "fail.do";  // 가칭
			break;
		}
		
		request.setAttribute("viewPage", viewPage);

	} // excute

} // CartOrderCommand