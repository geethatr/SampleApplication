package com.example.SampleApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.MessageChannels;

@Configuration
@EnableIntegration
@EnableMBeanExport
@SpringBootApplication

public class SampleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(SampleApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SampleApplication.class);
	}
	@Bean
	public QueueChannel exampleMessageChannel() {
		return MessageChannels.queue().get();
	}
}
