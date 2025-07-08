package kr.co.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.interceptor.UserInterceptor;

@Configuration
//1. WebMvcConfiguarer를 구현
public class interceptorConfig implements WebMvcConfigurer{
	
	//application.properties에 있는 속성값을 리스트로 받을 수 있다.
	@Value("${myapp.user.addPath}")
	List<String> addUserPathList;
	
	@Value("${myapp.user.excludePath}")
	List<String> excludeUserPathList;
	
	//2. 제작한 Interceptor의 의존성 주입
	@Autowired
	private UserInterceptor ui;
	
	/**
	 * 3.제작된 interceptor가  동작할 URI를 생성
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//UserInterceptor 등록.
		registry.addInterceptor(ui).addPathPatterns(addUserPathList).
		excludePathPatterns(excludeUserPathList);
		
		//여러개의 interceptor를 등록 가능
//		registry.addInterceptor(ti2).addPathPatterns(addPathList).
//		excludePathPatterns(excludePathList);
		
		
	}
}
