package com.zero.address.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 简单入口
 * @date 2018年1月10日 下午5:20:20
 * @author zero
 */
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
@PropertySource(value = {"classpath:application.properties", "classpath:datasource.properties"})
@ComponentScan(value = {"com.zero.address"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
