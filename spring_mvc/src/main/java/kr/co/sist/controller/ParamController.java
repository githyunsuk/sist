package kr.co.sist.controller;

import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

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
	public String singleType(String name2, int age, String addr, String gender) {
		System.out.println(name2 + " / " + age + " / " + addr + " / " + gender );
		return "day0619/param_result";
	}
	
	@RequestMapping(value="/dtoProcess", method=RequestMethod.POST)
//	@RequestMapping(value="/dtoProcess", method=RequestMethod.POST)
	public String dto(ParamDTO pDTO) {
		System.out.println(pDTO);
		return "day0619/param_result";
	}
	
	@PostMapping("/requestProcess")
	public String requestProcess(HttpServletRequest request, Model model) {
		System.out.println(model);
		ParamDTO pDTO = new ParamDTO();
		//request객체를 사용한 web parameter
		pDTO.setName(request.getParameter("name"));
		pDTO.setAge(Integer.parseInt(request.getParameter("age")));
		pDTO.setAddr(request.getParameter("name"));
		pDTO.setGender(request.getParameter("gender"));
		//접속자의 부가적인 정보를 얻기
		System.out.println(pDTO);
		System.out.println("접속자의 부가적인 정보");
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemotePort());
		System.out.println(request.getRequestURL());
		
		Enumeration<String> headerNames = request.getHeaderNames();
		String headerName = "";
		while(headerNames.hasMoreElements()) {
			headerName = headerNames.nextElement();
			System.out.println(headerName + " / " + request.getHeader(headerName));
		}
		return "day0619/param_result";
	}
}
