package com.epam.autothon.restassured.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import com.epam.autothon.Constants;
import com.epam.autothon.Utilities.ApplicationProperties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public  class BaseTestApi {
	protected ApplicationProperties appProperties;
	protected Response response; 
	Logger logger;
	
	public BaseTestApi(){
		logger = Logger.getLogger("BaseTestApi.class");
	}


	@BeforeClass
	public void setup(){
		System.out.println("in base tes setup");
		appProperties = ApplicationProperties.getInstance("api");
		appProperties.getProperty(Constants.REST_ASSURED_USER_PATH);
		
	}	
	
	public void setBaseUri(String uri) {
		RestAssured.baseURI = uri;
		logger.info("the base uri is set");
	}
	public void getURIPage(String uriParameter) {
		response=RestAssured.given().get("/"+uriParameter).andReturn();
		logger.info("Getting the response from page URI");
		
		//post request
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("FirstName", "Virender"); 
//		requestParams.put("LastName", "Singh");
//		 
//		requestParams.put("UserName", "simpleuser001");
//		requestParams.put("Password", "password1");
//		requestParams.put("Email",  "someuser@gmail.com");
//		// Add a header stating the Request body is a JSON
//		request.header("Content-Type", "application/json");
//
//		// Add the Json to the body of the request
//		request.body(requestParams.toJSONString());
//
//		// Post the request and check the response
//		Response response = request.post("/register");
		
		
		 String requestBody = "{\n" +
		            "  \"name\": \"tammy\",\n" +
		            "  \"salary\": \"5000\",\n" +
		            "  \"age\": \"20\"\n" +
		            "}";
		 
		 
		        Response response = null;
		 
		        try {
		            response = RestAssured.given()
		                .contentType(ContentType.JSON)
		                .body(requestBody)
		                .post("/create");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
		
	}
	
	public void responseNotNull() {
		Assert.assertNotNull(response);
	}
	
	public void verifyResponeStatusCode(int statusCode) {
		Assert.assertEquals(response.getStatusCode(),statusCode);
	}
	
	public String getResponeBody() {
		return response.getBody().asString();
	}
	
	public void verifyResponseField(String field, String expectedValue) {
		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.get(field),expectedValue);
	}
}
