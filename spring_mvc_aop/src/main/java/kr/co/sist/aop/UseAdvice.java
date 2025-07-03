package kr.co.sist.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UseAdvice {

//	@Before("execution( * kr.co.sist.day0701.TestAdviceService.before(..))")
//	@Before("execution( * kr.co.sist.day0701.TestAdviceService.bef*(..))")
	@Before("execution( String kr.co.sist.day0701.TestAdviceService.bef*(String))")
	public void useBefore(JoinPoint jp) {
		System.out.println("[AOP] useBefore : " + jp.getSignature().toShortString());
//		System.out.println(jp.getArgs().length);
		Object[] paramArr = jp.getArgs();
		if(paramArr.length > 0) {
			String str = (String)paramArr[0];
			System.out.println("입력 값 : " + str);
		}
	}
	
	@AfterReturning(
			pointcut = "execution( String kr.co.sist.day0701.TestAdviceService.afterReturning(String))",
			returning = "result"
			)
	public void useAfterReturning(JoinPoint jp, Object result) {
		System.out.println("[ AOP ] AfterReturning : " + jp.getSignature());
		System.out.println("[ AOP ] return Value : " + result);
	}
	
	@After("execution(* kr.co.sist.day0701.TestAdviceService.*(..))")
	public void useAfter(JoinPoint jp) {
		System.out.println("[ AOP ] After : " + jp.getSignature());
		
	}
	
	@AfterThrowing(
			pointcut = "execution(String kr.co.sist.day0701.TestAdviceService.afterThrowing(..))",
			throwing = "ex"
			)
	public void useAfterThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("[ AOP ] AfterThrowing : " + jp.getSignature());
		System.out.println("[ AOP ] throws 예외 객체 : " + ex);
	}
	
	@Around("execution(String kr.co.sist.day0701.TestAdviceService.around(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("[ AOP ] around : " + pjp.getSignature());
		
		long st = System.currentTimeMillis();
		//target method 실행
		Object obj = pjp.proceed();
		
		long et = System.currentTimeMillis();
		
		System.out.println("[ AOP ] around : " + pjp.getSignature());
		System.out.println("[ AOP ] around target 실행 시간 : " + (et - st) + "ms");
//		System.out.println("[ AOP ] around : " + pjp.getSignature());
		return obj;
	}
}
