package kr.co.sist.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("admin_id")
@Controller
public class AdminLoginController {

	@GetMapping("/admin/login/login_form")
	public String loginForm() {
		return "admin/login/login_frm";
	}
	
	@GetMapping("/admin/login/login_process")
	public String loginProcess(Model model) {
		//로그인작업 : 성공 > 대시보드, 실패 > 로그인 창  
		model.addAttribute("admin_id", "kim" );
		
		return "redirect:/admin/dashboard";
	}
	@GetMapping("/admin/logout")
	public String logoutProcess(Model model, SessionStatus ss) {
		//로그아웃
		ss.setComplete();
		
		return "redirect:/admin/login/login_form";
	}
	
	
}
