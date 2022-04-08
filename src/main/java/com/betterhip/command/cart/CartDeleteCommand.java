package com.betterhip.command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.cart.CartDeleteDao;

public class CartDeleteCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String[] deleteList = request.getParameterValues("chk");
		CartDeleteDao dao = new  CartDeleteDao();
		String viewPage = "";
		String deleteResult = dao.cartDelete(deleteList);
		
		switch(deleteResult) {
		case("success") :
			viewPage = "cartList..do";
			break;
		case("fail") :
			viewPage = "fail.do"; // <--------------------- 가칭 수정필요
 			break;
		}
		
		request.setAttribute("viewPage", viewPage);
		
	} // excute

} // CartDeleteCommand