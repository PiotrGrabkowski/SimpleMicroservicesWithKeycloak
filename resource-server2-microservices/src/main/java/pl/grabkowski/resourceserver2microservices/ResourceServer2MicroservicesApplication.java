package pl.grabkowski.resourceserver2microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ResourceServer2MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServer2MicroservicesApplication.class, args);
	}

}
