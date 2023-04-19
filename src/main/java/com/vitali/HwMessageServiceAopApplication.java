package com.vitali;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class HwMessageServiceAopApplication {
	private final MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(HwMessageServiceAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			messageService.send("Very important information!!!");
		};
	}

}
