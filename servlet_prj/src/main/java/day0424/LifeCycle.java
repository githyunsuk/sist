package day0424;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	
	@Override
	public void init() {
		System.out.println("최초 접속자에 의해 한번만 호출: 생성자의 코드 작성");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet, doPost, service 모든 접속자에 의해 여러번 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy가 정상종료되어 Servlet 소멸될 때 가장 마지막에 호출");
	}

}
