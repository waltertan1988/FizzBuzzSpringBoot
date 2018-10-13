package com.walter.fizzbuzz.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.walter.fizzbuzz.constant.Constant;
import com.walter.fizzbuzz.service.IntegerToStringService;

public class IntegerToBuzzServiceImplTest extends BaseTests{
	
	@Autowired
	@Qualifier("integerToBuzzServiceImpl")
	private IntegerToStringService integerToStringService;
	
	@Test
	public void supportTrue() {
		int n = 5;
		Assert.assertTrue(integerToStringService.support(n));
	}
	
	@Test
	public void supportTrueStage2() {
		int n = 51;
		Assert.assertTrue(integerToStringService.support(n));
	}
	
	@Test
	public void supportFalse() {
		int n = 3;
		Assert.assertFalse(integerToStringService.support(n));
	}
	
	@Test
	public void transfer() {
		int n = 5;
		String result = integerToStringService.transfer(n);
		Assert.assertArrayEquals(new String[] {Constant.BUZZ}, new String[] {result});
	}
}
