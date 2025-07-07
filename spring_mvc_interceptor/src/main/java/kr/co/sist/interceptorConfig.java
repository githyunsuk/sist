package kr.co.sist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.interceptors.TestInterceptor;

@Configuration
//1. WebMvcConfiguarer를 구현
public class interceptorConfig implements WebMvcConfigurer{
	
	//application.properties에 있는 속성값을 리스트로 받을 수 있다.
	@Value("${myapp.addPath}")
	List<String> addPathList;
	
	
	@Value("${myapp.excludePath}")
	List<String> excludePathList;
	//2. 제작하 Interceptor의 의존성 주입
	@Autowired
	private TestInterceptor ti;
	
	@Autowired
	private TestInterceptor ti2;
	
	/**
	 * 3/제작된 interceptor가  동작할 URI를 생성
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(ti).addPathPatterns("/");
//		registry.addInterceptor(ti).addPathPatterns("/","/hello");
//		registry.addInterceptor(ti).addPathPatterns("/","/hello","/bye");
		
//		//리스트에 경로를 설정
//		List<String> list = new ArrayList<String>();
//		list.add("/");
//		list.add("/hello");
//		list.add("/bye");
//		registry.addInterceptor(ti).addPathPatterns(list);
		
		//모든 하위 URI에 대해 동작 /**
//		registry.addInterceptor(ti).addPathPatterns("/**");
		
		//특정URI에 대해서는 동작하지 않도록 설정
//		registry.addInterceptor(ti).addPathPatterns("/**")
//		.excludePathPatterns("/hello");
		
		//List를 의존성 주입 받아서 사용.
		registry.addInterceptor(ti).addPathPatterns(addPathList).
		excludePathPatterns(excludePathList);
		
		//여러개의 interceptor를 등록 가능
//		registry.addInterceptor(ti2).addPathPatterns(addPathList).
//		excludePathPatterns(excludePathList);
		
		
		
		
		
		
	}
}
