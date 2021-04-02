package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {

	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().
		get("/users").
		then().
		statusCode(200).log().all();
		
	}
	
	//@Test
	public void POST() {
		
JSONObject request = new JSONObject ();
		
		request.put("firstName", "LakshmiSurekhar");
		request.put("lastName", "GovtEmployee");
		request.put("subjectId", 4);
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").then().statusCode(201).
		log().all();
		
		
	}
	
	//@Test
	public void testPUT() {
		
	
		
		JSONObject request = new JSONObject ();
		
		request.put("name", "LakshmiSurekha");
		request.put("job", "MahilaPolice");
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/5").then().statusCode(200).
		log().all();
}
	//@Test
	public void testPATCH() {
		
	
		
		JSONObject request = new JSONObject ();
		
		
		request.put("job", "wpsofficer");
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/5").then().statusCode(200).
		log().all();
	
}
	@Test
	public void Delete() {
		
	
		baseURI = "http://localhost:3000";
		when().
		delete("/users/4").then().statusCode(200);
	
	}
}
