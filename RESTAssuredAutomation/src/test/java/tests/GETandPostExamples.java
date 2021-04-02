package tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GETandPostExamples {

	@Test
	public void GET() {
		baseURI = "https://reqres.in/";
		given().
		get("api/users?page=2").
		then().
		statusCode(200).
		body("data[5].first_name", equalTo("Rachel")).
		body("data.first_name",hasItems("Byron","George"));
		//log().all();
		
		}

	@Test
	public void POST() {
		
		Map<String, Object>map = new HashMap<String,Object>();
//		map.put("name", "HarishKumar");
//		map.put("job", "Test Engineer");
//		System.out.println(map);
		
		
		JSONObject request = new JSONObject ();
		
		request.put("name", "LakshmiSurekhar");
		request.put("job", "GovtEmployee");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").then().statusCode(201).
		log().all();
		
		
	}




}
