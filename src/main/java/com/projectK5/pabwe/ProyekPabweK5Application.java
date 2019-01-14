package com.projectK5.pabwe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyekPabweK5Application {

	public static void main(String[] args) {

		SpringApplication.run(ProyekPabweK5Application.class, args);
	}

//	@Bean
//	WebMvcConfigurer webMvcConfigurer(){
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addResourceHandlers(ResourceHandlerRegistry registry) {
//				registry.addResourceHandler("/pages/smsgateway.html")
//						.addResourceLocations("classpath:/pages/");
//			}
//		};
//	}
}
