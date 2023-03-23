package hello.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration @MySpringBootApplication 를 사용하기 위해 주석처리
public class HelloConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
