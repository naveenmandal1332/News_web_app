package com.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.Exception.GlobalExceptionHandler;

@Configuration
@Import(GlobalExceptionHandler.class)
public class AppConfg {

}
