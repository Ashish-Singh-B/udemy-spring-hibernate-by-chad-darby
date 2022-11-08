package com.luv2code.springdemo.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String[] messages = {
			"First random message",
			"Second random message",
			"Third random message"
		};
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return messages[random.nextInt(messages.length)];
	}

}
