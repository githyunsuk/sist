package kr.co.sist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired(required = false)
	private MemberService ms;
	
	@GetMapping("/user/memberFrm")
	public String joinFrm() {
		return "user/joinFrm";
	}
	
	@PostMapping("/user/memberProcess")
	public String joinFrmProcess(MemberDTO mDTO, HttpServletRequest request, Model model) {
		
		//ip설정
		mDTO.setIp(request.getRemoteAddr());
		
		model.addAttribute("name", mDTO.getName());
		model.addAttribute("addResult",ms.addMember(mDTO));
		model.addAttribute("id", mDTO.getId());
		
		return "user/joinResult";
	}
	
	@GetMapping("/user/login")
	public String loginFrm(HttpSession session) {
		String id = (String)session.getAttribute("session_id");
		System.out.println("---------------" + id);
		String moveURL = "user/loginFrm";
		if(id != null) {
			moveURL = "index";
		}
		return moveURL;
	}
	
	@PostMapping("/user/loginProcess")
	@ResponseBody  //ViewResolver를 거치지 않고 직접 응답 ( Model이 실행되지 않음 )
	public String loginProcess(LoginDTO lDTO, HttpSession session) {
		
		String jsonObj = ms.searchLogin(lDTO);
		if(jsonObj.contains("true")) {
			session.setAttribute("session_id", lDTO.getId());
		}
		System.out.println(jsonObj);
		
		return jsonObj;
	}
}
