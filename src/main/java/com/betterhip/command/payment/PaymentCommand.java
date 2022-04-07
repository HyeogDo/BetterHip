package com.betterhip.command.payment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.payment.PaymentDao;
import com.betterhip.dto.payment.PaymentDto;

public class PaymentCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int purchase_id = Integer.parseInt(request.getParameter("purchase_id"));
		
		PaymentDao dao = new PaymentDao();
		ArrayList<PaymentDto> dtos = dao.payment(purchase_id);
		request.setAttribute("payment", dtos);
		
		
		
	}

}
