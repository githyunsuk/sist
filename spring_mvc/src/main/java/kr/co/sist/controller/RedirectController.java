package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

	@GetMapping("/day0620/redirect")
	public String redirect() {
		
		String move = "day0620/request_success";
		if(new Random().nextBoolean()) {
			move = "redirect:/call.html";
		}
		
		return move;
		
	}
}
