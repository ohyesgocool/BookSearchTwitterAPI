package com.test.goodread.base;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.BookSearch;
import twitterAPI.TwitterAPITest;

public class BaseTest {
	@Test(priority = 1)
	public void postTweetTest() throws IOException {
		TwitterAPITest objt = new TwitterAPITest();
		objt.postTweet();

	}

	@Test(priority = 2)
	public void bookSearchTest() throws Exception {
		BookSearch objb = new BookSearch();
		objb.getTweet();
		objb.goodRead();

	}

}
