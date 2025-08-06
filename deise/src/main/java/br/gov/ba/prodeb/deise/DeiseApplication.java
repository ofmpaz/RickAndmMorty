package br.gov.ba.prodeb.deise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeiseApplication.class, args);
	}

}
