package files;

import java.io.FileInputStream;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.Properties;

import org.testng.ReporterConfig.Property;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class reusableMethods {
	
	static Properties prop;

	public static JsonPath Json(String resource) {
		
		JsonPath jp=new JsonPath(resource);
		return jp;
	}
	
    public static XmlPath Xml(String resource) {
		
	XmlPath xml=new XmlPath(resource);
		return xml;
	}
    
    public static Properties variables() throws IOException {
    	FileInputStream fi=new FileInputStream("D:\\Exclipseworkspace\\Restassuredproject\\src\\main\\java\\Files\\env.properties");
		prop=new Properties();
		prop.load(fi);
		return prop;
    }
    
    
    public static  String getSessionKey() throws IOException {
    	
    	RestAssured.baseURI=variables().getProperty("JiraHost");
    	Response rawRes=given().
    	body("{ \"username\": \"nag\", \"password\": \"password\" }").
    	when().get("/rest/auth/1/session").then().statusCode(200).and().extract().response();
    	String strresponse=rawRes.asString();
    	String key= Json(strresponse).get("session.value");
    	return key;
    }
}
