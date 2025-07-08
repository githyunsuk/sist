package kr.co.sist.user.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

	@GetMapping("/user/mypage/user_info")
	public String myPage() {
		return "mypage/userInfo";
	}
}
