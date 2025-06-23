package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;

//@SessionAttributes("name") //값 하나
@SessionAttributes({"name", "age"}) //값 여러개
@Controller
public class SessionController {

	@GetMapping("/day0623/useSession")
	public String sessionList() {
		return "day0623/session_list";
	}
	
	@GetMapping("/day0623/session_setvalue")
	public String sessionSetValue(HttpSession session) {
		//세션 생존시간 설정
		//세션 값 설정
		session.setAttribute("name", "이장훈");
		session.setAttribute("age", 25);
		return "day0623/session_list";
	}
	
	@GetMapping("/day0623/session_getvalue")
	public String sessionGetValue(HttpSession session) {
		//세션 값 얻기
		String name = (String)session.getAttribute("name");
		Integer sessionAge = (Integer)session.getAttribute("age");
		int age = 0;
		if(sessionAge != null) {
			age = sessionAge.intValue();
		}
		System.out.println("이름 : " + name+", 나이 : " + age);
		return "day0623/session_list";
	}
	
	   @GetMapping("/day0623/model_setvalue")
	   public String modelSetValue(Model model) {
	      model.addAttribute("name", "주현석");
	      model.addAttribute("age", 27 );
	      
	      
	      return "day0623/session_list";
	   }
	   
	   @GetMapping("/day0623/model_getvalue")
	   public String modelGetValue(Model model) {
		   //Spring 5.2 이상에서만 사용 가능.
		   String name = (String)model.getAttribute("name");
		   Integer modelAge = (Integer)model.getAttribute("age");
		   int age = 0;
		   if(modelAge != null) {
			   age = modelAge.intValue();
		   }
		   System.out.println("Model 이름 : " + name+", 나이 : " +age);
		   
		   return "day0623/session_list";
	   }
	   
	   @GetMapping("/day0623/session_complete")
	   //HttpSession으로는 값을 삭제할 수 없다.
	   public String useSessionComplete(SessionStatus ss) {
		   System.out.println("삭제 전 " + ss.isComplete());
		   ss.setComplete();
		   System.out.println("삭제 후 " + ss.isComplete());
		   
		   return "redirect:/";
	   }
	   
}
