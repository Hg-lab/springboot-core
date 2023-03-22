package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

// 애플리케이션을 초기화하는 서블릿
/*
    애플리케이션 초기화가 별도로 있는 이유
        1. 인터페이스 구현 후 META-INF/services 하위에 등록해줄 필요가 없음
        2. 서블릿 컨테이너와 의존성을 줄일 수 있다
 */

public class AppInitV1Servlet implements AppInit{
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartup");

        // 순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet =
                servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet"); // 프로그래밍 방식의 서블릿 등록
    }
}
