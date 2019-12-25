package Sampleone.Restassuredproject;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import files.Resources;
import files.reusableMethods;
public class xmlReq {
	
	Properties prop;
	@BeforeTest
	public void envvariables() throws IOException {
		FileInputStream fi=new FileInputStream("D:\\Exclipseworkspace\\Restassuredproject\\src\\main\\java\\Files\\env.properties");
		prop=new Properties();
		prop.load(fi);
		
		
	}
	
	@Test
	public void Postre() throws IOException {
		
		RestAssured.baseURI=prop.getProperty("Host");
		
		String Postdata=GenerateStringFromResource("C:\\Users\\nagen\\PostPayLoad.xml");
		Response xmlres=given().
		queryParam("Key",prop.getProperty("Key")).
		body(Postdata).
		when().
		get(Resources.post()).
		then().assertThat().statusCode(200).and().header("Server", "Apache").and().
		header("Access-Control-Allow-Methods", "POST").extract().response();
		String xmlstring=xmlres.asString();
		System.out.println(xmlstring);
		reusableMethods.Xml(xmlstring);
		}
	
	public static String GenerateStringFromResource(String Path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(Path)));
	}
	}
