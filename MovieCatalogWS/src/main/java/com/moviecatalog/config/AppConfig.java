package com.moviecatalog.config;  
  
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
  
@Configuration 
@ComponentScan("com.moviecatalog") 
@EnableWebMvc
public class AppConfig {  

}  
