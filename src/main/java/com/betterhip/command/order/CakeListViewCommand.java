package com.betterhip.command.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.order.CakeListDao;
import com.betterhip.dto.order.CakeListDto;

public class CakeListViewCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int start;
		int len = 4;
		try {
			start = Integer.parseInt(request.getParameter("start"));
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			start = 0;
			len = 4;
		}
		
		
		CakeListDao dao = new CakeListDao();
		
		ArrayList<CakeListDto> dtos = dao.list(start,len,"cake_id");
		request.setAttribute("list", dtos);
		HttpSession session = request.getSession();
		session.setAttribute("totalRows", dao.getTotalRows());
	}

}
