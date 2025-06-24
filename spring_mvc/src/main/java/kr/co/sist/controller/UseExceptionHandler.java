package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/day0624")
public class UseExceptionHandler {

	@GetMapping("/exception1")
	//예외가 발생되면 DispatcherServlet이 잡는다.
	public String exception() throws ClassNotFoundException {
		
		String className = "java.lang.String";
		if(new Random().nextBoolean()) {
			className = "java.lang.String1";
		}
		Class.forName(className);
		
		return "day0624/exception_result";
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	//반환형 ModelAndView, 매개변수 : @ExceptionHandler에 선언된 예외처리 클래스
	public ModelAndView processException(ClassNotFoundException cnfe) {
		//객체 생성
		ModelAndView mav = new ModelAndView();
		//View 명 설정
		mav.setViewName("err/err_cnfe");
		//view에 전달할 메시지
		mav.addObject("errm", cnfe.getMessage());
		
		cnfe.printStackTrace();
		
		return mav;
	}
}
