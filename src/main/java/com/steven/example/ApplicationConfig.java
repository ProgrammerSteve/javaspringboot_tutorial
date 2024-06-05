package com.steven.example;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {
    @Bean("bean1")
    @Profile("dev")
    //@Qualifier("bean1")
	public MyFirstClass myFirstBean(){
		return new MyFirstClass("First Bean");
	}
    @Bean
    //@Qualifier("bean2")
    @Profile("dev")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("Second Bean");
    }
    @Bean
    //@Qualifier("bean3")
    @Primary
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("Third Bean");
    }
}
