package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;


public class JSONSchemaValidation {
	@Test
	public void GET() {
		baseURI = "https://reqres.in/";
		given().
		get("api/users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
		statusCode(200).
		log().all();
		
		}

}
