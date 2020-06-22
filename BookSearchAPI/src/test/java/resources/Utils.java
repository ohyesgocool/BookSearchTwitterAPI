package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import twitterAPI.TwitterAPITest;

public class Utils {
	public static RequestSpecification req;

	public static String getGlobalValue(String key) throws IOException {
		// Method to fetch global property
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/global.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	

	public static String splitTweet(String tweet)

	{
		String authorName = null, location;

		if (tweet.contains("#Whatsthebookname ")) {
			String tweetNameArr[] = tweet.split("#Whatsthebookname ");
			authorName = tweetNameArr[1];
			return authorName;

		}
		else if (tweet.contains("#WhatstheWeather ")) {
			String tweetNameArr[] = tweet.split("#WhatstheWeather ");
			location = tweetNameArr[1];
			return location;

		}
		return null;

	}

	public static RequestSpecification logging() throws IOException {
		// Method for logging API

		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;

	}
	public static JsonPath getTweetJSON(Response r) throws IOException {
		
		String json = r.asString();
		JsonPath jspath = new JsonPath(json);
		return jspath ;
	}

}
