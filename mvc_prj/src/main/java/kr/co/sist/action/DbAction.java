package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbAction implements Action {

	private boolean forwardFlag;
	private String movePage;
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

	@Override
	public String movePage() {
		return movePage;
	}

}
