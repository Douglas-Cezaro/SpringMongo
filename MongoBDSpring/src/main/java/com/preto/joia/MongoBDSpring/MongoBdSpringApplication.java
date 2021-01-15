package com.preto.joia.MongoBDSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class MongoBdSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoBdSpringApplication.class, args);
	}

}
