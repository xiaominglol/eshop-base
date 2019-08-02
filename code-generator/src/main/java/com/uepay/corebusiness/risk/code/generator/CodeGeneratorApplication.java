package com.uepay.corebusiness.risk.code.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeGeneratorApplication {

	public static void main(String[] args) {
		System.out.println("args = [" + args + "]");
		SpringApplication.run(CodeGeneratorApplication.class, args);
	}
}
