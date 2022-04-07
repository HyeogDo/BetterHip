package com.betterhip.command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.payment.PaymentDao;

public class PaymentSuccessCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String purchase_id = request.getParameter("purchase_id");
		String purchase_kakao_id = request.getParameter("purchase_kakao_id");
		
		PaymentDao dao = new PaymentDao();
		dao.paySuccess(purchase_id, purchase_kakao_id);

	}

}
