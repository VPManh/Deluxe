package vn.vpm.deluxe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
  @SpringBootApplication(
  	exclude =  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class DeluxeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeluxeApplication.class, args);
	}

}


