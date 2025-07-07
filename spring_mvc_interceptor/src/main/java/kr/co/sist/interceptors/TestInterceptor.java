package kr.co.sist.interceptors;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//1. HandlerInterceptor를 구현
@Component
public class TestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("요청URI : "+ request.getRequestURI());
		System.out.println( "1. preHandle호출 : HandlerMapper가 호출되기전 실행");
		
		boolean flag=new Random().nextBoolean();
		if( flag ) {
		response.sendRedirect("http://localhost:8080/error.html");
		}//end if 
		
		
//		return true; //return true -> H.M > Controller > V.R > View
//		return false; //return false -> 응답
		return flag; //return false -> 응답
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println( "2. postHandle호출 : view( JSP,HTML )가 호출되기전 실행");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println( "3. afterCompletion호출 : view가 응답되고 실행");
	}

	
}
