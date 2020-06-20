package weatherSearch;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.Utils;

public class WeatherSearchAPI {

	public static Response getWeather() throws IOException {
		// Get API of Twitter
		// BaseURL or Host
		RestAssured.baseURI = Utils.getGlobalValue("weatherapiurl");

		Response response = given().queryParam("Key", Utils.getGlobalValue("weatherKey")).queryParam("q", "Bengaluru")
				.when().get("v1/current.json").then().extract().response();

		return response;
	}
}
