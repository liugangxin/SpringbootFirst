package com.liu;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.liu.model.AsyncBean;
import com.liu.service.GitHubLookupService;

@Component
public class AsyncTest implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(AsyncTest.class);

	private final GitHubLookupService gitHubLookupService;

	public AsyncTest(GitHubLookupService gitHubLookupService) {
		this.gitHubLookupService = gitHubLookupService;
	}

	@Override
	public void run(String... args) throws Exception {
		// Start the clock
		long start = System.currentTimeMillis();

		// Kick of multiple, asynchronous lookups
		Future<AsyncBean> page1 = gitHubLookupService.findUser("PivotalSoftware");
		Future<AsyncBean> page2 = gitHubLookupService.findUser("CloudFoundry");
		Future<AsyncBean> page3 = gitHubLookupService.findUser("Spring-Projects");

		// Wait until they are all done
		while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
			Thread.sleep(10); // 10-millisecond pause between each check
		}

		// Print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		logger.info("--> " + page1.get());
		logger.info("--> " + page2.get());
		logger.info("--> " + page3.get());
	}
}
