package kr.co.sist.user.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
