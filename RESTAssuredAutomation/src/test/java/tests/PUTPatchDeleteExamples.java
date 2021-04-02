package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUTPatchDeleteExamples {

	@Test
	public void testPUT() {
		
	
		
		JSONObject request = new JSONObject ();
		
		request.put("name", "LakshmiSurekha");
		request.put("job", "MahilaPolice");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/2").then().statusCode(200).
		log().all();
		
		
	}

	@Test
	public void testPATCH() {
		
	
		
		JSONObject request = new JSONObject ();
		
		request.put("name", "LakshmiSurekha");
		request.put("job", "MahilaPolice");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/api/users/2").then().statusCode(200).
		log().all();
	
	}
	
	
	
	@Test
	public void testDelete() {
		
	
		
		
		baseURI = "https://reqres.in";
		given().
		
		when().
		delete("/api/users/2").then().statusCode(204).
		log().all();
	
	}
}
