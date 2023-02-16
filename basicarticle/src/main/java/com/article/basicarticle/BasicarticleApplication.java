package com.article.basicarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicarticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicarticleApplication.class, args);
	}

}
