package kr.co.sist.admin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/admin/user_list")
	public String userList() {
		// group by로 집계된 데이터를 조회하여 Model에 추가
		return "admin/user/user_list";
	}
}
