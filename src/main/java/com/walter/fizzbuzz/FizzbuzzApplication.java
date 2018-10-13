package com.walter.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.walter.fizzbuzz.enumeration.FizzBuzzStratageEnum;
import com.walter.fizzbuzz.service.FizzBuzzService;
import com.walter.fizzbuzz.service.IntegerToStringService;

@SpringBootApplication
public class FizzbuzzApplication {
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FizzbuzzApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		context = application.run(args);
		
		execute(100);
	}

	/**
	 * Fizz/Buzz business logic is executed here
	 * @param n
	 */
	protected static void execute(int n) {
		List<IntegerToStringService> integerToStringServiceList = new ArrayList<IntegerToStringService>();
		integerToStringServiceList.add(context.getBean("integerToFizzServiceImpl", IntegerToStringService.class));
		integerToStringServiceList.add(context.getBean("integerToBuzzServiceImpl", IntegerToStringService.class));
		
		FizzBuzzService fizzBuzzService = context.getBean("fizzBuzzServiceImpl", FizzBuzzService.class);
		
		for(int i=1; i<=n; i++) {
			String result = fizzBuzzService.output(i, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);
			System.out.println(result);
		}
	}
}
