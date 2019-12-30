package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.reusableMethods;
import static io.restassured.RestAssured.given;

import java.io.IOException;

public class Resources {
	static String Sessionid;
	
	public static String post() {
		String postreq= "/maps/api/place/add/json";
		return postreq;
	} 
	
	public static String delete() {
		String deletereq="/maps/api/place/delete/json";
		return deletereq;
	}
	
	public static String Addbook() {
		String add="/Library/Addbook.php";
		return add;
	}
}
