package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/day0619") //클래스에서 상위 URI를 설정할 수 있다.
public class ParamController {

	@GetMapping("/day0619/param_frm")
//	@GetMapping("/param_frm")
	public String parameterFrm() {
		
		return "day0619/param_frm";
	}
	
	/**
	 * 단일형으로 web parameter 처리
	 * @return
	 */
	@PostMapping("/singleTypeProcess")
//	@PostMapping("/singleTypeProcess")
	public String singleType(String name, int age, String addr, String gender) {
		System.out.println(name + " / " + age + " / " + addr + " / " + gender );
		return "day0619/param_result";
	}
	
	@RequestMapping(value="/dtoProcess", method=RequestMethod.POST)
//	@RequestMapping(value="/dtoProcess", method=RequestMethod.POST)
	public String dto(ParamDTO pDTO) {
		System.out.println(pDTO);
		return "day0619/param_result";
	}
}
