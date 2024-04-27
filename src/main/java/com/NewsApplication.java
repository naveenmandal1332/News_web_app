package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.Config.AppConfg;

@SpringBootApplication
@ComponentScan(basePackages = "com.Controller")
@Import(AppConfg.class)
public class NewsApplication {

  public static void main(String[] args) {
    SpringApplication.run(NewsApplication.class, args);
  }

}
