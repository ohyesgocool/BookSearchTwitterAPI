package goodReads;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import resources.Utils;

public class GoodReadTest {
	public static Response response;

	public static Response getBookData(String authorName) throws IOException {
		try {
			// GoodReads API implementation
			RestAssured.baseURI = Utils.getGlobalValue("goodReadURL");
			response = given().queryParam("key", Utils.getGlobalValue("goodReadKey")).queryParam("q", authorName)
					.queryParam("secret", Utils.getGlobalValue("goodReadsecret")).when().get("search/index.xml").then()
					.extract().response();

			Assert.assertEquals(response.getStatusCode(), 200);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return response;

	}

}
