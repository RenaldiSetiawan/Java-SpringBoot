package com.backend.tourtraveljava;

import com.backend.tourtraveljava.storage.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
//anotasi utk baca storage properties
@EnableConfigurationProperties(StorageProperties.class)
public class TourtravelJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourtravelJavaApplication.class, args);
	}

}
