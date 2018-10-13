package com.walter.fizzbuzz.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.walter.fizzbuzz.constant.Constant;
import com.walter.fizzbuzz.service.IntegerToStringService;

/**
 * IntegerToStringService implementation for FIZZ case.
 * @author hp
 */
@Service
@Order(1)
public class IntegerToFizzServiceImpl implements IntegerToStringService {

	@Override
	public String transfer(int n) {
		return Constant.FIZZ;
	}

	@Override
	public boolean support(int n) {
		return 0 == n%3;
	}

}
