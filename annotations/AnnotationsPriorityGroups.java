package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsPriorityGroups {
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
	//priority can be negative, lesser the value higher the priority.
	//for same priority test case will execute as per alphabetic order
	//grouping of test cases: will divide test cases as per groups in html report
	@Test(priority=1,groups="mk")
	public void titleGoogle(){
		String s = driver.getTitle();
		System.out.println("Title of Google: "+s  );
	}
	@Test(priority=2,groups="mk")
	public void mailLink(){
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(b);
	}
	@Test(priority=3,groups="ak")
	public void googleLogo(){
		boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(b);
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}}
