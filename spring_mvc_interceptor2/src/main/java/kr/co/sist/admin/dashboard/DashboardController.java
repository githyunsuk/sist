package kr.co.sist.admin.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/admin/dashboard")
	public String dashboard(Model model){
		//group by로 집계된 데이터를 조회하여 Model에 추가
		System.out.println("dashboard-----------------");
		return "admin/dashboard/dashboard";
	}
}
