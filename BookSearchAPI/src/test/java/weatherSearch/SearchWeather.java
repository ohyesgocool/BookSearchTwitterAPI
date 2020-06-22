package weatherSearch;

import java.io.IOException;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Utils;
import twitterAPI.TwitterAPITest;

public class SearchWeather {

	String weather,tweetName;

	public void searchWeather() throws IOException {
		Response response =TwitterAPITest.getQueryFromTwitter();
		JsonPath jspath = Utils.getTweetJSON(response);
		List<?> arr = jspath.get("array");
		for (int i = 0; i < arr.size(); i++) {
			tweetName=this.tweetName;
			tweetName = (jspath.get("[" +i+ "].text").toString());
			
		}
		System.out.println(tweetName);
		Response res = WeatherSearchAPI.getWeather();
		String json = res.asString();
		JsonPath jsspath = new JsonPath(json);
		weather = this.weather;
		weather = jsspath.get("current.temp_c").toString();
		String retweet = "Hey The weather at your place is " + " " + weather + " " + "Hope you are having a Nice day";
		System.out.println(retweet);

	}
}
