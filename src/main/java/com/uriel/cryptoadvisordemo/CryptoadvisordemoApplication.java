package com.uriel.cryptoadvisordemo;

import com.uriel.cryptoadvisordemo.configurations.ChatProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ChatProperties.class)
public class CryptoadvisordemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoadvisordemoApplication.class, args);
	}

}
