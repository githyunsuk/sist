package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HTML Form Control의 이름과 매개변수 명이 다를 때
 */
@Controller
@RequestMapping("/day0620")
public class RequestParamController {

	//
	@GetMapping("/req_param_frm")
//	public String reParamFrm() {
	public void reqParamFrm() {
		// return "day0620/req";
	}

	@GetMapping("/req_param_process")
	public String reqParamProcess(ParamDTO2 pDTO, String email, 
			@RequestParam(value="email3", defaultValue="sist.co.kr", required=false) String domain){
		
		pDTO.setUseEmail(email + "@" + domain);
		System.out.println(pDTO);
		return "day0620/req_param_process";
	}
}