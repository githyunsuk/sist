package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    private final IncludeController includeController;

    CookieController(IncludeController includeController) {
        this.includeController = includeController;
    }

	@GetMapping("/day0623/useCookie")
	public String useCookie() {
		return "day0623/cookie_list";
	}
	
	@GetMapping("/day0623/setCookie")
	public String setCookie(HttpServletResponse response) {
		//쿠키 생성
		Cookie cookie = new Cookie("name", "이장훈");
		Cookie cookie2 = new Cookie("age", "25");
		
		//생존시간 설정
		cookie.setMaxAge(60*60*24);
		cookie2.setMaxAge(60*60*24);
		
		//쿠키 심기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "day0623/cookie_list";
	}
	
	@GetMapping("/day0623/getCookie")
	public String getCookie(HttpServletRequest request) {
		//쿠키들 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie tempCookie : cookies) {
				System.out.println(tempCookie.getName() + " / " + tempCookie.getValue());
			}
		}
		return "day0623/cookie_list";
	}
	@GetMapping("/day0623/getCookieAnnotaion")
	public String getCookieAnnotaion(@CookieValue(value="name", defaultValue="홍길동") String name, @CookieValue(value="age")String age) {
		
		System.out.println("name 쿠키 값 : " + name + ", age 쿠키 값 : " + age);
		return "day0623/cookie_list";
	}
}
