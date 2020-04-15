package com.kentravels.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.kentravels.app"/* ,exclude=SecurityAutoConfiguration.class */ )
@EnableJpaRepositories("com.kentravels.app.repository")
@EntityScan("com.kentravels.app.entity")
@EnableTransactionManagement
@ComponentScan("com.kentravels.app")
public class BusBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplication.class, args);
	}

}
