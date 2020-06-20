package weatherSearch;

import java.io.IOException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import twitterAPI.TwitterAPITest;

public class SearchWeather {
	String weather;

	public void searchWeather() throws IOException {
		Response response = WeatherSearchAPI.getWeather();
		String json = response.asString();
		JsonPath jspath = new JsonPath(json);
		weather = this.weather;
		weather = jspath.get("current.temp_c").toString();
		System.out.println(weather);

	}
}
