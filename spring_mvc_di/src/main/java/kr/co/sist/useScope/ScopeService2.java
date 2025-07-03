package kr.co.sist.useScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Scope("prototype")
@Getter
@Setter
public class ScopeService2 {
	
	private String name;
	private int age;

}
