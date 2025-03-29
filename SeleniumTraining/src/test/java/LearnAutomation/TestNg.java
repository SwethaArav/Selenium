package LearnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg {
	@Test

	public void loginInTest() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
	//	driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
	//	driver.findElement(By.xpath("//span[text()='Products']")).getText();
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		File file= driver.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:\\Automation\\SS\\TestPage.png"));
		driver.close();
	}

}
