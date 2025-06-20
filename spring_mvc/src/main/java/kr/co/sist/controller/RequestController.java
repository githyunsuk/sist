package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RequestController {

	@GetMapping("/get_method")
//	@RequestMapping(value="/get_method", method=RequestMethod.GET)
	public String getMethod() {
		System.out.println("getMethod");
		return "day0619/get_result";
	}
	
	@PostMapping("/post_method")
	public String postMethod() {
		System.out.println("postMethod");
		return "day0619/post_result";
	}
	
//	@GetMapping("/get_post_method")
//	@PostMapping("/get_post_method")
	@RequestMapping(value="/get_post_method", method= {GET,POST})
	public String getPostMethod(HttpServletRequest request) {
		System.out.println("요청방식 : " + request.getMethod());
		request.setAttribute("method", request.getMethod());
		return "day0619/get_post_result";
	}
	
	
}
