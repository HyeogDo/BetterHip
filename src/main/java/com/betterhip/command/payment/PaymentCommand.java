package com.betterhip.command.payment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.payment.PaymentDao;
import com.betterhip.dto.payment.PaymentDto;

public class PaymentCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// user_id 가져오기
		String user_id = request.getParameter("user_id");

		// dao 선언
		PaymentDao dao_payment = new PaymentDao();
		
		// Dto 와 paymentUser 매서드 연결 (유저 정보)
		PaymentDto dto_payment_user = dao_payment.paymentUser(user_id);
		request.setAttribute("paymentUser", dto_payment_user);
		
		// Dto 와 paymentCake 매서드 연결 (상품 정보)
		PaymentDto dto_payment_cake = dao_payment.paymentCake(user_id);
		request.setAttribute("paymentCake", dto_payment_cake);
		
		//paymentPriceList 매서드 연결 (주문 총 가격)
		int dto_purchase_price = dao_payment.paymentPriceList(user_id);
		request.setAttribute("total_price", dto_purchase_price);
		
		//paymentCount 매서드 연결 (주문 수량)
		int dto_purchase_count = dao_payment.paymentCount(user_id);
		request.setAttribute("purchase_count", dto_purchase_count);
		
	}

}
