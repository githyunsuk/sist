package kr.co.sist.useScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
public class ScopeController {

	@Autowired
	private ScopeService ss;
	
	@Autowired
	private ScopeService2 ss2;
	
	@Value("${prgData.version}")
	private String version;
	@Value("${prgData.pubDate}")
	private String pubDate;
	@Value("${prgData.company}")
	private String company;

	@GetMapping("/singleton")
	public String useSingleton(String name, 
			@RequestParam(value="age", defaultValue = "0") String age) {
		System.out.println("프로그램 버전 : " + version);
		System.out.println("배포일자 : " + pubDate);
		System.out.println("고객사 : " + company);
		
		ss.info();
		
		ss.setName(name);
		if(!"0".equals(age)) {
			ss.setAge(Integer.parseInt(age));
		}
		System.out.println("사용한 객체 : " + ss);
		System.out.println("값 : " + ss.getName() + "/" + ss.getAge());
		return "day0630/result";
	}

	@GetMapping("/prototype")
	public String usePrototype(String name, 
			@RequestParam(value="age", defaultValue = "0") String age) {
		ss2.setName(name);
		if(!"0".equals(age)) {
			ss2.setAge(Integer.parseInt(age));
		}
		
		System.out.println("사용한 객체 : " + ss2);
		System.out.println("값 : " + ss2.getName() + "/" + ss2.getAge());
		return "day0630/result";
	}
}
