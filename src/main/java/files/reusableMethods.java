package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ReporterConfig.Property;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

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
}
