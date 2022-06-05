package hello.springmvc;

import hello.springmvc.basic.springstart.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringmvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	/*@Bean
	SpringMemberFormControllerV1 springMemberFormControllerV1() {
		return new SpringMemberFormControllerV1();
	}*/
}
