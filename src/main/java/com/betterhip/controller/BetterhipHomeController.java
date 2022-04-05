package com.betterhip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.command.cart.CartDeleteCommand;
import com.betterhip.command.cart.CartListCommand;
import com.betterhip.command.cart.CartOrderCommand;
import com.betterhip.command.login.FindIdCommand;
import com.betterhip.command.login.FindPwCommand;
import com.betterhip.command.login.LoginCommand;
import com.betterhip.command.main.CakeAdCommand;
import com.betterhip.command.mypage.PurchaseCancelCommand;
import com.betterhip.command.mypage.PurchaseCancelListCommand;
import com.betterhip.command.mypage.PurchaseListCommand;
import com.betterhip.command.mypage.UserInfoDeleteCommand;
import com.betterhip.command.mypage.UserInfoDeleteViewCommand;
import com.betterhip.command.mypage.UserInfoModifyCommand;
import com.betterhip.command.mypage.UserInfoModifyViewCommand;
import com.betterhip.command.order.CakeChoiceCommand;
import com.betterhip.command.order.CakeListViewCommand;
import com.betterhip.command.order.CakeOrderCartCommand;
import com.betterhip.command.order.CakeOrderPaymentCommand;
import com.betterhip.command.order.CakeReviewCommand;
import com.betterhip.command.order.CakeReviewWriteCommand;
import com.betterhip.command.payment.PaymentCommand;
import com.betterhip.command.payment.PaymentListCommand;
import com.betterhip.command.payment.PaymentSuccessCommand;
import com.betterhip.command.signup.SignUpCommand;

/**
 * Servlet implementation class BetterhipHomeController
 */
@WebServlet("*.do")
public class BetterhipHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BetterhipHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPage = null;
		BetterhipCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();		
		String com = uri.substring(conPath.length());
		
		switch(com) {
		case("/main.do") :
			command = new CakeAdCommand();
			command.excute(request, response);
			viewPage = "main.jsp";
			break;
			
		case("/guideCake.do") :
			viewPage = "guideCake.jsp";
			break;
			
		case("/guidePickup.do") :
			viewPage = "guidePickup";
			break;           
			
		case("/guideUse.do") :
			viewPage = "guideUse";
			break;
			
		case("/purchaseList.do") :
			command = new PurchaseListCommand();
			command.excute(request, response);
			viewPage = "purchaseList.jsp";
			break;
			
		case("/purchaseCancel.do") :
			command = new PurchaseCancelCommand();
			command.excute(request, response);
			viewPage = "purcrchaseList.do";
			break;
			
		case("/refundList,do") :
			command = new PurchaseCancelListCommand();
			command.excute(request, response);
			viewPage = "purchaseList.jsp";
			break;
			
		case("/userInfoModifyView.do") :
			command = new UserInfoModifyViewCommand();
			command.excute(request, response);
			viewPage = "userInfoView.jsp";
			break;
			
		case("/userInfoModify.do") :
			command = new UserInfoModifyCommand();
			command.excute(request, response);
			viewPage = "userInfoModifyView,do";
			break;
			
		case("/userInfoDeleteView.do") :
			command = new UserInfoDeleteViewCommand();
			command.excute(request, response);
			viewPage = "userInforDeleteView.jsp";
			break;
			
		case("/userInfoDelete.do") :
			command = new UserInfoDeleteCommand();
			command.excute(request, response);
			viewPage = "goodbye.jsp";
			break;
			
		case("/cakeListView.do") :
			command = new CakeListViewCommand();
			command.excute(request, response);
			viewPage = "cakeList.jsp";
			break;
			
		case("/cakeChoice.do") :
			command = new CakeChoiceCommand();
			command.excute(request, response);
			viewPage = "cakeInfo.jsp";
			break;
			
		case("/cakeOrderCart.do") :
			command = new CakeOrderCartCommand();
			command.excute(request, response);
			viewPage = "cartList.do";
			break;
			
		case("/cakeOrderPayment.do") :
			command = new CakeOrderPaymentCommand();
			command.excute(request, response);
			viewPage = "paymentList.do";
			break;
			
		case("/cakeReview.do") :
			command = new CakeReviewCommand();
			command.excute(request, response);
			viewPage = "cakeInfo.jsp";
			break;
			
		case("/cakeReviewWrite.do") :
			command = new CakeReviewWriteCommand();
			command.excute(request, response);
			viewPage = "cakeReview.do";
			break;
			
		case("/cartList.do") :
			command = new CartListCommand();
			command.excute(request, response);
			viewPage = "cartList.jsp";
			break;
			
		case("/cartDelete.do") :
			command = new CartDeleteCommand();
			command.excute(request, response);
			viewPage = "cartList.do";
			break;
			
		case("/cartOrder.do") :
			command = new CartOrderCommand();
			command.excute(request, response);
			viewPage = "paymentList.do";
			break;
			
		case("/paymentList.do") :
			command = new PaymentListCommand();
			command.excute(request, response);
			viewPage = "paymentList.jsp";
			break;
			
		case("/payment.do") :
			command = new PaymentCommand();
			command.excute(request, response);
			viewPage = "payment.jsp";
			break;
			
		case("/paySuccess.do") :
			command = new PaymentSuccessCommand();
			command.excute(request, response);
			viewPage = "paySuccess.jsp";
			break;
			
		case("/payFailure.do") :
			viewPage = "payFailure.jsp";
			break;
		
		case("/goShopping.do") :
			viewPage = "cakeList.do";
			break;
		
		case("/payView.do") :
			viewPage = "purchaseList.do";
			break;
		
		case("/signupForm.do") :
			viewPage = "signupForm.jsp";
			break;
		
		case("/signup.do") :
			command = new SignUpCommand();
			command.excute(request, response);
			viewPage = "signupResult";
			break;
		
		case("/loginForm.do") :
			viewPage = "login.jsp";
			break;
		
		case("/login.do") :
			command = new LoginCommand();
			command.excute(request, response);
			viewPage = "main.do";
			break;
		
		case("/findIdPage.do") :
			viewPage = "findId.jsp";
			break;
			
		case("/findId.do") :
			command = new FindIdCommand();
			command.excute(request, response);
			viewPage = "printID.jsp";
			break;
			
		case("/gotoLogin.do") :
			viewPage = "loginForm.do";
			break;
			
			
		case("/findPwPage.do") :
			viewPage = "findPw.jsp";
			break;
			
		case("/findPw.do") :
			command = new FindPwCommand();
			command.excute(request, response);
			viewPage = "printPw.jsp";
			break;
		}
				
	} // actionDo

} // BetterhipHomeController
