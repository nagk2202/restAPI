package Sampleone.Restassuredproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import files.reusableMethods;

import static io.restassured.RestAssured.given;

import java.io.IOException;

public class authorizationReq {

	
	
	
	@Test
	public void getToken() throws IOException, InterruptedException {
		
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=https://rahulshettyacademy.com/getCourse.php&auth_uri=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/userinfo.email&response_type=code");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("nagendrab493");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		String url=driver.getCurrentUrl();
		String norml=url.split("?code")[1];
		String code=norml.split("&scope")[0];
		
		
		//getting access tokens
		String accessToken=given().urlEncodingEnabled(false).
		queryParams("code",code).
		queryParams("client_id",reusableMethods.variables().getProperty("client_id")).
		queryParams("client_secret",reusableMethods.variables().getProperty("client_secret")).
		queryParams("redirect_uri",reusableMethods.variables().getProperty("redirect_uri")).
		queryParams("grant_type","authorization_code").
		when().
		post(reusableMethods.variables().getProperty("access_token_uri")).asString();
		
		JsonPath js=reusableMethods.Json(accessToken);
		String token=js.get("access_token");
		
		
		//getresources of rahulshetty.com
	
		
		String resources=given().urlEncodingEnabled(false).
		queryParams("access_token",token).
		when().
		get(reusableMethods.variables().getProperty("redirect_uri")).asString();
		System.out.println(resources);
		
	}
}
