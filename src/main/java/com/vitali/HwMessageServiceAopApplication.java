package com.vitali;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Slf4j
@Configuration
@ImportResource("classpath:aop-config.xml")
@SpringBootApplication
@RequiredArgsConstructor
public class HwMessageServiceAopApplication {
	private final MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(HwMessageServiceAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner1(){
		return args -> {
			messageService.send("Very important information!!!");
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner2() {
		return args -> {
			try {
				messageService.sendException();
			} catch (Exception e) {
				log.error("Exception occurred while sending message: {}", e.getMessage());
			}
		};
	}


}
