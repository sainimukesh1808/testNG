package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AnnotationsExample {
	WebDriver driver; 
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\msi26\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();//will create null pointer exception
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.Google.com");
	}
	@Test
	public void titleGoogle(){
		String s = driver.getTitle();
		System.out.println("Title of Google: "+s  );
	}
	@Test
	public void mailLink(){
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}


}
