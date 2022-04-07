package com.betterhip.command.payment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.payment.PaymentDao;
//import com.betterhip.dao.payment.PaymentDao;
//import com.betterhip.dao.payment.PaymentUserDao;
import com.betterhip.dto.payment.PaymentDto;
//import com.betterhip.dto.payment.PaymentDto;
//import com.betterhip.dto.payment.PaymentUserDto;

public class PaymentListCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
//		int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));
//		
		PaymentDao dao_purchase_list = new PaymentDao();
		ArrayList<PaymentDto> dtos_purchase_list = dao_purchase_list.paymentList(user_id);
		request.setAttribute("paymentList", dtos_purchase_list);
		
		
//		ArrayList<Integer> purchase_id = (ArrayList)session.getAttribute("purchase_id");
		
		
		PaymentDao dao_purchase_user = new PaymentDao();
		PaymentDto dto_purchase_user = dao_purchase_user.paymentUserList(user_id);
		request.setAttribute("paymentUserList", dto_purchase_user);
		
		PaymentDao dao_purchase_price = new PaymentDao();
		int dto_purchase_price = dao_purchase_price.paymentPriceList(user_id);
		request.setAttribute("total_price", dto_purchase_price);
		
		

	}

}