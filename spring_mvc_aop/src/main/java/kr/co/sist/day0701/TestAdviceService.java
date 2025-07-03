package kr.co.sist.day0701;

import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class TestAdviceService {

	public String before(String msg) {
		System.out.println("[ Service ] before :  " + msg);
		
		return "오늘은 화요일";
	}
	
	public String afterReturning(String msg) {
		System.out.println("[ Service ] afterReturning :  " + msg);
		
		return "내일은 수요일";
	}
	
	public String afterThrowing(String msg) throws Exception {
		System.out.println("[ Service ] afterThrowing :  " + msg);
		
		if(new Random().nextBoolean()) {
			throw new Exception("예외가 발생하였습니다.");
		}
		return "스프링 프레임워크 첫걸음.";
	}
	public String around(String msg){
		
		System.out.println("[ Service ] around :  " + msg);
		
		return "AWS(PaaS, IaaS, SaaS)인프라 구축 가이드";
	}
}
