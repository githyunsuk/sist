package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.action.BusinessAction;
import kr.co.sist.action.DbAction;
import kr.co.sist.action.MainAction;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
       
	private static Map<String, Action> map = new HashMap<String, Action>();
	
	static {
		map.put("M001", new MainAction()); //메인화면으로 이동
		map.put("F001", new BusinessAction()); //업무로직을 처리하고 폼을 제공
		map.put("P001", new DbAction()); //DB업무를 사용하는 액션
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || "".equals(cmd) || !map.containsKey(cmd)) {
			cmd = "M001"; //메인을 보여주는 키로 설정
		}
		
		Action action = map.get(cmd);
		action.execute(request, response);
		moveURL(request, response, action.isForward(), action.movePage());
		
	}
	
	private void moveURL(HttpServletRequest request, HttpServletResponse response, boolean forwardFlag, String movePage) throws ServletException, IOException {
		if(forwardFlag) {
			RequestDispatcher rd = request.getRequestDispatcher(movePage);
			rd.forward(request, response);
		} else {
			response.sendRedirect(movePage);
		}
	}
;
}
