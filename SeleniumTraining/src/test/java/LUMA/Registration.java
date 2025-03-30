package LUMA;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {
	@Test

	public void Registration() throws Exception {
		// Chrome driver set up
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Launch URL
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		// Click Create an Account cta
		driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
		// Enter First Name
		driver.findElement(By.id("firstname")).sendKeys("FirstName");
		// Enter Last Name
		driver.findElement(By.id("lastname")).sendKeys("LastName");
		// Set email address and Enter Email Address
		System.setProperty("Email", "dalaniy703@nokdot.com");
		driver.findElement(By.id("email_address")).sendKeys("dalaniy703@nokdot.com");
		// Set Password and enter password
		System.setProperty("Password", "abcd@1234");
		driver.findElement(By.id("password")).sendKeys("abcd@1234");
		// Enter Confirm Password
		driver.findElement(By.id("password-confirmation")).sendKeys("abcd@1234");
		// Hit Create an Account button on registration page
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		// Verify User landed on My Account page after registration
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		// Take Screenshot of My account page
		File Reg = driver.getScreenshotAs(OutputType.FILE);
		Files.copy(Reg, new File("C:\\Automation\\SS\\LumaRegistrationSuccessful.png"));
		// Click on dropdown button near welcome message
		driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
		// Click Sign out button
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		//Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		Thread.sleep(8000);
		// Verify User landed on home page after sign out
		String expectedHome = "Home Page";
		String actualHome = driver.getTitle();
		Assert.assertEquals(actualHome, expectedHome);
		// Click Sign IN button in home page
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		// Enter email id which is already created in registration process
		driver.findElement(By.id("email")).sendKeys(System.getProperty("Email"));
		// Enter Password of the email id which is already registered
		driver.findElement(By.id("pass")).sendKeys(System.getProperty("Password"));
		// Click Sign In button
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
		// Verify User landed on My Account page after Sign in
		String expectedPostSignIn = "Home Page";
		String actualPostSignIn = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		// Screenshot of My Account page after sign In
		File SignIn = driver.getScreenshotAs(OutputType.FILE);
		Files.copy(SignIn, new File("C:\\Automation\\SS\\LumaSignInSuccessful.png"));
		driver.close();
	}
}
