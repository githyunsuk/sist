package kr.co.sist.user.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/user/login/login_form")
	public String loginForm() {
		return "login/loginForm";
	}
}
