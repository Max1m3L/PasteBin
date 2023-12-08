package com.maxlvshv.pastebin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PasteBinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteBinApplication.class, args);
	}

}
