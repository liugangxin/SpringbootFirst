package com.liu.mq;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisReceiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

	private CountDownLatch latch;

	public RedisReceiver(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		LOGGER.info("Received <" + message + ">");
		latch.countDown();
	}
}
