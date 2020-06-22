package resources;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import goodReads.GoodReadTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import twitterAPI.TwitterAPITest;

public class BookSearch {
	public static String tweetID, bookName, authorName;

	// Method to get the Author Name inputed by user

	public void getTweet() throws Exception {
		Response response = TwitterAPITest.getQueryFromTwitter();
		JsonPath jspath = Utils.getTweetJSON(response);
		List<?> arr = jspath.get("array");
		for (int i = 0; i < arr.size(); i++) {
			tweetID = (jspath.get("[" + i + "].id").toString());
			String tweetName = (jspath.get("[" + i + "].text").toString());
			authorName = this.authorName;
			authorName = Utils.splitTweet(tweetName);
			break;

		}

	}

	public static void goodRead() throws Exception {
		// Method to get the Book Name From GoodRead API
		if (authorName != null && !("".equals(authorName))) {
			Response response = GoodReadTest.getBookData(authorName);
			if (response != null) {
				try {
					JSONObject xmlJSONObj = XML.toJSONObject(response.asString());
					String json = xmlJSONObj.toString(4);
					// System.out.println(json);
					JsonPath jspath = new JsonPath(json);

					List<?> bookArr = jspath.get("GoodreadsResponse.search.results.work");
					if (bookArr != null) {
						for (int i = 0; i < bookArr.size(); i++) {
							String bookAuthor = (jspath
									.get("GoodreadsResponse.search.results.work[" + i + "].best_book.author.name")
									.toString());
							System.out.println(bookAuthor);
							if (bookAuthor.equalsIgnoreCase(authorName)) {
								System.out.println(bookAuthor);
								bookName = (jspath
										.get("GoodreadsResponse.search.results.work[" + i + "].best_book.title")
										.toString());

								// Constructing URL as per GoodReadAPI Guidelines
								bookName = bookName.replace(" ", "%20");
								String URL = "https://www.goodreads.com/book/title?id=" + bookName;
								// URL and TweetID to retweet API
								TwitterAPITest.URL = URL;
								TwitterAPITest.TWEETID = tweetID;
								TwitterAPITest.reTweet();

								break;
							}
						}
					} else {
						throw new Exception("Array doesn't have value");
					}

				} catch (JSONException je) {
					je.printStackTrace();
				}

			}

		} else {
			throw new Exception("Author Name is Empty");
		}
	}
}
