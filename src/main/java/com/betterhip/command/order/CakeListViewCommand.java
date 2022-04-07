package com.betterhip.command.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betterhip.command.BetterhipCommand;
import com.betterhip.dao.order.CakeListDao;
import com.betterhip.dto.order.CakeListDto;

public class CakeListViewCommand implements BetterhipCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		CakeListDao dao = new CakeListDao();
		ArrayList<CakeListDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
