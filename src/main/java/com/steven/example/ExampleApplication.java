package com.steven.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) {
		var app=new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx=app.run( args);

		//MyFirstClass myFirstClass=ctx.getBean("myFirstClass",MyFirstClass.class);
		//MyFirstClass myFirstClass=ctx.getBean(MyFirstClass.class);
		//MyFirstClass myFirstClass=ctx.getBean("myBean",MyFirstClass.class);
		MyFirstService myFirstService=ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
//		System.out.println(myFirstService.getJavaVersions());
//		System.out.println(myFirstService.getOsName());
//		System.out.println(myFirstService.readProp());


		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustomPropertyInt());

	}
}
