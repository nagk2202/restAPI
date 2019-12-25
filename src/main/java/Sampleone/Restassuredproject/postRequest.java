package Sampleone.Restassuredproject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Resources;
import files.payLoad;
import files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class postRequest {
	
	
	Properties prop;
	String placeid;

@BeforeTest
	public void envvariables() throws IOException {
		FileInputStream fi=new FileInputStream("D:\\Exclipseworkspace\\Restassuredproject\\src\\main\\java\\Files\\env.properties");
		prop=new Properties();
		prop.load(fi);
		
		
	}
	
@Test
public void Post() {
	
	RestAssured.baseURI=prop.getProperty("Host"); 
	Response Res=given().
	queryParam("key",prop.getProperty("Key")).
	body(payLoad.Postbody()).
	when().
	get(Resources.post()).then().assertThat().statusCode(200).and().header("Server", "Apache").and().
	header("Access-Control-Allow-Methods", "POST").
	extract().response();
	
	String Response=Res.asString();
	placeid = reusableMethods.Json(Response).get("place_id");
}


@Test
public void deleteReq() {
	RestAssured.baseURI=prop.getProperty("Host");
	given().
	queryParam("key",prop.getProperty("Key")).
	body(payLoad.deletebody(placeid)).
	when().
	post(Resources.delete()).
	then().assertThat().statusCode(200).and().body("status", equalTo("OK"));
	
}	
}
