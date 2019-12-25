package Sampleone.Restassuredproject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class First {

	@Test
	public void getRequest() {
		// TODO Auto-generated method stub
       RestAssured.baseURI="https://maps.googleapis.com"; 
       given().
       param("key", "AIzaSyA4pqknH1Gj6PyF0JHzev4RdJk8QeRUj2Y").
       param("radius", "500").
       param("types","food").param("name", "harbour").
       param("location", "-33.8670522,151.1957362").
       when().
       get("/maps/api/place/textsearch/json").
       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).body("results[0].name", equalTo("Sydney")).
       body("status",equalTo("OK")).header("Content-Type", "application/json; charset=UTF-8").
       header("Server", "scaffolding on HTTPServer2");
		       
	}

}
