package TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsInvocationCountTimeOutExpectedException {
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
	//invocationCount mean how much time you want to run test case
	@Test(invocationCount=3)
	public void titleGoogle(){
		String s = driver.getTitle();
		System.out.println("Title of Google: "+s  );
		Assert.assertEquals(s, "Google");
	}
	//timeOut: test case will terminate after 5sec automatically.
	@Test(timeOut=5000)
	public void infiniteLoop(){
		for(int j=0;j<100000;j++){
			System.out.println(j);
		}}
	
	//expectedExceptions: will catch exception and exception will not catch.
	@Test(expectedExceptions=NumberFormatException.class)
	public void testException(){
		String s = "100A";
		Integer.parseInt(s);//will give NumberFormatException, but will handled by expectedExceptions
		System.out.println(s);
		}
		
	

	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
