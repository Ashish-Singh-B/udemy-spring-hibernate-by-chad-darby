package com.luv2code.springdemo.annotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a very sad day for me";
	}

}
