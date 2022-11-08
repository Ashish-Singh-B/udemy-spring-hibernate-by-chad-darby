package com.luv2code.springdemo.annotations;

public class BoringFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "I am too tired to give any fortune";
	}

}
