package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	// 컴포넌트 스캔 없이 직접 스프링 빈에 등록해도 됨
	// @Bean
	// SpringMemberFormControllerV1 springMemberFormControllerV1() {
	// return new SpringMemberFormControllerV1();
	// }

}
