package twitterAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Utils;

import static io.restassured.RestAssured.given;
import java.io.IOException;

import org.testng.Assert;

public class TwitterAPITest extends Utils {
	public static Response response = null;
	public static String URL, TWEETID;

	public static Response getQueryFromTwitter() throws IOException {
		// Get API of Twitter
		// BaseURL or Host
		RestAssured.baseURI = Utils.getGlobalValue("baseurl");

		try {
			response = given().spec(logging()).auth()
					.oauth(Utils.getGlobalValue("ConsumerKey"), Utils.getGlobalValue("ConsumerSecret"),
							Utils.getGlobalValue("Token"), Utils.getGlobalValue("TokenSecret"))
					.queryParam("count", "3").when().get("/home_timeline.json").then().extract().response();

			Assert.assertEquals(response.getStatusCode(), 200);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	// Post API

	public static void postTweet(String tweet) throws IOException {
		
		if (Utils.getGlobalValue("isTweetFromAutomation").equals("1")) {
			RestAssured.baseURI = Utils.getGlobalValue("baseurl");
			Response res = given().spec(logging()).auth()
					.oauth(Utils.getGlobalValue("ConsumerKey"), Utils.getGlobalValue("ConsumerSecret"),
							Utils.getGlobalValue("Token"), Utils.getGlobalValue("TokenSecret"))
					.queryParam("status", tweet).when().post("/update.json").then().extract().response();

			String response = res.asString();

			JsonPath js = new JsonPath(response);
		}

		}

	

	// ReTweet

	public static Response reTweet() throws IOException {
		System.out.println(URL + "   -  " + TWEETID);
		RestAssured.baseURI = Utils.getGlobalValue("baseurl");
		try {
			response = given().spec(logging()).auth()
					.oauth(Utils.getGlobalValue("ConsumerKey"), Utils.getGlobalValue("ConsumerSecret"),
							Utils.getGlobalValue("Token"), Utils.getGlobalValue("TokenSecret"))
					.queryParam("status", URL).queryParam("in_reply_to_status_id", TWEETID)
					.queryParam("auto_populate_reply_metadata", "true").when().post("/update.json").then().extract()
					.response();
			Assert.assertEquals(response.getStatusCode(), 200);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

}
