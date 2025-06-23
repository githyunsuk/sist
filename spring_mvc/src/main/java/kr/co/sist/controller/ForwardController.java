package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day0623")
public class ForwardController {

	@GetMapping("/forwardA")
	public String forwardA() {
//		return "/forwardB";
		return "forward:/day0623/forwardB";
	}
	@GetMapping("/forwardB")
	public String forwardB() {
//		return "/forwardC";
		return "forward:/day0623/forwardC";
//		return "redirect:/day0623/forwardC";
	}
	@GetMapping("/forwardC")
	public String forwardC() {
		return "day0623/result_forward";
	}
}
