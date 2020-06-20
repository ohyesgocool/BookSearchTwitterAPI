package com.test.goodread.base;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.BookSearch;
import twitterAPI.TwitterAPITest;
import weatherSearch.SearchWeather;
import weatherSearch.WeatherSearchAPI;

public class BaseTest {
	/*
	 * @Test(priority = 1) public void postTweetTest() throws IOException {
	 * TwitterAPITest twitter = new TwitterAPITest(); twitter.postTweet();
	 * 
	 * }
	 * 
	 * @Test(priority = 2) public void bookSearchTest() throws Exception {
	 * BookSearch book = new BookSearch(); book.getTweet(); book.goodRead();
	 * 
	 * }
	 */
	@Test
	public void watherSearch() throws IOException 
	{
		SearchWeather weather = new SearchWeather();
		
		weather.searchWeather();
		
	}

}
