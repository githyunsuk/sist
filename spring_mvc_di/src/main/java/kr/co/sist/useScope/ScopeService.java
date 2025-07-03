package kr.co.sist.useScope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class ScopeService {
	
	private String name;
	private int age;
	
	@Value("${prgData.version}")
	private String version;
	@Value("${prgData.pubDate}")
	private String pubDate;
	@Value("${prgData.company}")
	private String company;
	
	public void info() {
		System.out.println("ss프로그램 버전 : " + version);
		System.out.println("ss배포일자 : " + pubDate);
		System.out.println("ss고객사 : " + company);
	}
	
}
