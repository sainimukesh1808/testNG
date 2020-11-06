package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDependsOnMethods {
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
	//dependsOnMethodsL: syntax for single dependency 
	//dependsOnMethods={"titleGoogle","mailLink"}
	//jis pe dependent h wo saare test cases pass honge tbhi dependent test case run hoga, skipped otherwise.
	//
	@Test()
	public void titleGoogle(){
		String s = driver.getTitle();
		System.out.println("Title of Google: "+s  );
		int k = 10/0;
		System.out.println(k);
	}
	@Test()
	public void mailLink(){
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	@Test(dependsOnMethods={"titleGoogle","mailLink"})
	public void googleLogo(){
		boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(b);
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
