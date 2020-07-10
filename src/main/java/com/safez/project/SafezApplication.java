package com.safez.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SafezApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafezApplication.class, args);
		System.setProperty("webdriver.chrome.driver", "/Users/supinrong/code/driver/chromedriver");
	}

}