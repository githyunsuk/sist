package kr.co.sist.loosely;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.day0627.Test;
import us.test.OutPack;

@Controller
public class LooselyController {
	
	//의존성 주입
//	@Autowired//어셈블리를 의존성주입 받겠다
//	private Assembly ass;
//	@Autowired
//	private Test test;
//	@Autowired
//	private OutPack out;
	
	@RequestMapping(value="/",method= {GET,POST})
	public String memberIndex() {
//		System.out.println("ass -- "+ass);
//		System.out.println("test -- "+test);
//		System.out.println("out -- "+out);
		return "index";
	}//memberIndex
	
	@GetMapping("/member/add_process")
	public String addMember( TestDTO tDAO,Model model) {
		Assembly ass=new Assembly();
		Service service=ass.getBean();
		model.addAttribute("addResult",service.add(tDAO)); 
		model.addAttribute("data",tDAO);
		return "member/addResult";
	}//addMember
	
	@GetMapping("/member/search")
	public String searchMember(Model model) {
		Assembly ass=new Assembly();
		Service service=ass.getBean(); 
		model.addAttribute("data", service.search());
		
		return "member/memberlist";
	}//searchMember
	
	
	
}//class
  