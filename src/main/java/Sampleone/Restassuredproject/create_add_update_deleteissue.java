package Sampleone.Restassuredproject;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import files.Resources;
import files.reusableMethods;
import files.payLoad;
import static io.restassured.RestAssured.given;

public class create_add_update_deleteissue {
	
	@Test
	public void createIssue() throws IOException {
		
		RestAssured.baseURI=reusableMethods.variables().getProperty("JiraHost");
		given().
		header("cookie","JSESSIONID="+reusableMethods.getSessionKey()).
		body(payLoad.createissuePay()).when().
		post("/rest/api/2/issue/").then().statusCode(201);
		
	}
	

}
