package com.walter.fizzbuzz.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.walter.fizzbuzz.constant.Constant;
import com.walter.fizzbuzz.enumeration.FizzBuzzStratageEnum;
import com.walter.fizzbuzz.exception.FizzBuzzException;
import com.walter.fizzbuzz.service.FizzBuzzService;
import com.walter.fizzbuzz.service.IntegerToStringService;

public class FizzBuzzServiceImplTest extends BaseTests{

	@Autowired
	private FizzBuzzService fizzBuzzService;
	@Autowired
	private List<IntegerToStringService> integerToStringServiceList;

	@Test
	public void outputNumber() {
		int n = 1;
		String result = fizzBuzzService.output(n, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);
		Assert.assertArrayEquals(new String[] {String.valueOf(n)}, new String[] {result});
	}
	
	@Test
	public void outputFizz() {
		int n = 3;
		String result = fizzBuzzService.output(n, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);
		Assert.assertArrayEquals(new String[] {Constant.FIZZ}, new String[] {result});
	}
	
	@Test
	public void outputBuzz() {
		int n = 5;
		String result = fizzBuzzService.output(n, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);
		Assert.assertArrayEquals(new String[] {Constant.BUZZ}, new String[] {result});
	}
	
	@Test
	public void outputFizzBuzz() {
		int n = 15;
		String expected = (Constant.FIZZ + Constant.BUZZ);
		String result = fizzBuzzService.output(n, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_ASC);
		Assert.assertArrayEquals(new String[] {expected}, new String[] {result});
	}
	
	@Test(expected=FizzBuzzException.class)
	public void outputException() {
		int n = 1;
		String result = fizzBuzzService.output(n, integerToStringServiceList, FizzBuzzStratageEnum.APPEND_ALL_DESC);
		Assert.assertArrayEquals(new String[] {String.valueOf(n)}, new String[] {result});
	}
}
