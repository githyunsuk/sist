package kr.co.sist.day0630;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired(required = false)
	private TestService ts;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/searchName")
	public String ctrSearchName(String id, Model model) {
		System.out.println("[ Controller ] : ctrSearchName");
		model.addAttribute("name", ts.searchName(id));
		
		return "day0630/searchResult";
	}
}
