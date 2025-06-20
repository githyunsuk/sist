package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sist.service.DataService;

@Controller
public class DataSendController {
	
	@Autowired(required = false)
	private DataService ds;
	
	@GetMapping("/day0620/data_send")
	public String dataSend() {
		return "day0620/data_send";
	}
	
	@PostMapping("/day0620/useModel")
	//1.매개변수로 Model을 선언
	public String useModel(Model model) {
		//2.model에 값 추가
//		DataService ds = new DataService();
		model.addAttribute("dataObj", "Model");
		model.addAttribute("names", ds.searchNames());
		model.addAttribute("nowDate", ds.nowDate());
		
		return "day0620/data_result";
	}
	
	@PostMapping("/day0620/useMav")
	public ModelAndView useMav() {
		//1.ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		//2.view명 설정
		mav.setViewName("day0620/data_result");
		//3.data 설정
//		DataService ds = new DataService();
		mav.addObject("dataObj", "ModelAndView");
		mav.addObject("names", ds.searchNames());
		mav.addObject("nowDate", ds.nowDate());
		//4.mav반환
		return mav;
	}
	
	@PostMapping("/day0620/useRequest")
	public String useRequest(HttpServletRequest request) {
		
		//값 설정
		request.setAttribute("dataObj", "HttpServletRequest");
		request.setAttribute("names", ds.searchNames());
		request.setAttribute("nowDate", ds.nowDate());
		
		return "day0620/data_result";
		
	}
}
