package com.rumo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.rumo","service"})
@MapperScan("com.rumo.mapper")
public class RumoSpringbootMyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RumoSpringbootMyblogApplication.class, args);
	}
}
