package kr.co.sist.day0618;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
	@GetMapping("/")
	public String index() {
		return "index"; //WEB-INf/views/hello.jsp
	}
}
