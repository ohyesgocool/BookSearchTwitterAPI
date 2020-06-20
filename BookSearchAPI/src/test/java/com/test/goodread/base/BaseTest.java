package com.test.goodread.base;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.BookSearch;
import resources.Utils;
import twitterAPI.TwitterAPITest;
import weatherSearch.SearchWeather;
import weatherSearch.WeatherSearchAPI;

public class BaseTest {

	@Test(priority = 1) public void postTweetTest() throws IOException {
		 String tweet = null;
	 
		 
				if (Utils.getGlobalValue("section").equals("weather")) {
					tweet = Utils.getGlobalValue("tweetWeather");

				} else if (Utils.getGlobalValue("section").equals("book")) {
					tweet = Utils.getGlobalValue("tweetBook");
				}
	  TwitterAPITest twitter = new TwitterAPITest(); TwitterAPITest.postTweet(tweet);
	 
	  }

	/*
	 * * @Test(priority = 2) public void bookSearchTest() throws Exception {
	 * BookSearch book = new BookSearch(); book.getTweet(); book.goodRead();
	 * 
	 * }
	 */
	@Test
	public void watherSearch() throws IOException {
		SearchWeather weather = new SearchWeather();

		weather.searchWeather();

	}

}
