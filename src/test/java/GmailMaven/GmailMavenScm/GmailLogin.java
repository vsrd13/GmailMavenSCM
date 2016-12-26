package GmailMaven.GmailMavenScm;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailLogin {
	
	public static WebDriver driver;
	public static String baseUrl = "https://www.gmail.com";
	
	@BeforeClass
	public static void setUp() throws IOException {
		File dir = new File("./");
		String path = dir.getCanonicalPath();
		System.setProperty("webdriver.chrome.driver", path+ "//BrowserDrivers//chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public static void LoginTest() {
		
		driver.get(baseUrl + "/");
		driver.findElement(By.id("Email")).sendKeys("ramanakumar.sai@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("anupama.413");
		driver.findElement(By.id("signIn")).click();
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
