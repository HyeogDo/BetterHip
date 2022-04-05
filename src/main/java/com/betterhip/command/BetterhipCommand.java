package com.betterhip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BetterhipCommand {
	
	public void excute(HttpServletRequest request, HttpServletResponse response);
	

}
