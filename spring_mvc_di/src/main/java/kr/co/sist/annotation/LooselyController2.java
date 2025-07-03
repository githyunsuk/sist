package kr.co.sist.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LooselyController2 {
	
	@Autowired(required = false)
	private Service service; 
	
	@GetMapping("/member2/add_process")
	public String addMember( TestDTO tDAO,Model model) {
		model.addAttribute("addResult",service.add(tDAO)); 
		model.addAttribute("data",tDAO);
		return "member2/addResult";
	}//addMember
	
	@GetMapping("/member2/search")
	public String searchMember(Model model) {
		model.addAttribute("data", service.search());
		
		return "member2/memberlist";
	}//searchMember
	
	
	
}//class
  