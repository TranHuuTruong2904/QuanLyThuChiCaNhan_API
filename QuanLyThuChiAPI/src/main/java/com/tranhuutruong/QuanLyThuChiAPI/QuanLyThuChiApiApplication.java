package com.tranhuutruong.QuanLyThuChiAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;


@EnableScheduling
@SpringBootApplication
public class QuanLyThuChiApiApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(QuanLyThuChiApiApplication.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
		application.run(args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));   // It will set UTC timezone
		System.out.println("Spring boot application running in UTC timezone :" + new Date());   // It will print UTC timezone
	}
//	@Bean
//	public RouterFunction<ServerResponse> swaggerUI() {
//		return RouterFunctions.route(RequestPredicates.GET("/swagger"),
//				request -> ServerResponse.permanentRedirect(URI.create(request.path() + "/index.html?url=/api-docs")).build()).and(RouterFunctions
//				.resources("/swagger/**", new ClassPathResource("swagger-ui/")));
//	}

}
