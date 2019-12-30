package Sampleone.Restassuredproject;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.reusableMethods;
import static io.restassured.RestAssured.given;
import files.payLoad;
import files.Resources;

public class addBook {

@Test(dataProvider="Book")
public void addBookReq(String bookname, String isbn, String aisle) throws IOException {
	
	RestAssured.baseURI=reusableMethods.variables().getProperty("Host");
	
	Response Res=given().
	header("Content-Type","application/json").
	body(payLoad.AddbookpayLoad(bookname, isbn, aisle)).
	when().
	post(Resources.Addbook()).
	then().assertThat().statusCode(200).extract().response();
	String stringresponse=Res.asString();
	JsonPath js=reusableMethods.Json(stringresponse);
	System.out.println(js.get("ID"));	
}

@DataProvider(name="Book")
public Object[][] getdata(){
	
	 return new Object[][] { {"test", "testuser_1", "Test@123" }, {"test","testuser_2", "Test@123" }, {"test","testuser_3", "Test@123" }};
	}
	
}
