package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IncludeController {

	@GetMapping("/header")
	public String header() {
		return "fragments/header";
	}
	
	@GetMapping("/footer")
	public String footer() {
		return "fragments/footer";
	}
	
	@GetMapping("/day0623/useInclude")
	public String useInclude() {
		return "day0623/use_include";
	}
}
