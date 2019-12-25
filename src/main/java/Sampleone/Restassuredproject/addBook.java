package Sampleone.Restassuredproject;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.reusableMethods;
import static io.restassured.RestAssured.given;
import files.payLoad;
import files.Resources;

public class addBook {

@Test
public void addBookReq() throws IOException {
	
	RestAssured.baseURI=reusableMethods.variables().getProperty("Host");
	
	Response Res=given().
	header("Content-Type","application/json").
	body(payLoad.AddbookpayLoad()).
	when().
	post(Resources.Addbook()).
	then().assertThat().statusCode(200).extract().response();
	String stringresponse=Res.asString();
	JsonPath js=reusableMethods.Json(stringresponse);
	System.out.println(js.get("ID"));	
}
	
}
