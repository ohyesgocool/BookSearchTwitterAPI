WhatsTheBookName is an API Based maven project which will find one of the book name of the given author.
It uses twitter as a platform to get the book details .
 GoodRead Book link will be commented to the orginal tweet using the tweet ID.
Twitter API's which uses oauth1 are used in developing this project along with GoodRead API's to search and build the goodread Link.
isTweetFromAutomation is a parameter which allows to tweet using automation scripts . 
if it is not enabled , the script will check for 3 latest tweets from the twitter account.
If #Whatsthebookname is found in any of the three tweets , script will return the book link for the latest one .
#Whatsthebookname <AuthorName> is the format in which user should enter the tweet . Any other format will not be considered.
RestAssured API with BDD framework is used with java as binding language.
Maven is used as build tool.
TestNG is used as test framework. All the API Logs will be logged in "logger.txt".



Twitter Account User Name  testingprofilemytestprofile@gmail.com
Password  TXl0ZXN0aW5nYWNjb3VudEAxMg==