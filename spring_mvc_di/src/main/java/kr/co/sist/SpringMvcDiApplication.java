package kr.co.sist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"kr.co.sist", "us.test"})
@SpringBootApplication
public class SpringMvcDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDiApplication.class, args);
	}

}
