package kma.ManamentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ManamentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManamentApiApplication.class, args);
	}

}
