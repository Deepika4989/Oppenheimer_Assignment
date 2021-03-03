package Selenium_Example;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class GovernorView {
	public String baseUrl = "http://localhost:8080/";
    String driverPath = "C:\\Program Files\\Java\\chromedriver.exe";
    public WebDriver driver ;
	   
        @BeforeTest
	    public void openBrowser()
	    {
        	System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl);
            
	        
	    }
	    @Test(priority=1)
	    public void verifyButtonColor() {
	    	
	    String buttonColor = driver.findElement(By.xpath("//*[@id=\"contents\"]/a[2]")).getCssValue("background-color");
	    
		String hex = Color.fromString(buttonColor).asHex();
		String RedColor = "FF0000";
		System.out.println(hex);
		Assert.assertEquals(hex, RedColor);
	    }
		@Test(priority =2)
		public void verifyButtonDisplay()
		{
			
		WebElement button = driver.findElement(By.xpath("//*[@id=\"contents\"]/a[2]"));
		System.out.println(button.getText());
		String ButtonDisplay = button.getText();
		String ExpectDisplay = "Dispense Now";
		Assert.assertEquals(ButtonDisplay, ExpectDisplay);
		}
		@Test(priority=3)
		public void verifyCashDispense()
		{
		driver.findElement(By.xpath("//*[@id=\"contents\"]/a[2]")).click();
	    String expect_text = "Cash dispensed";
   	    String actualText = driver.findElement(By.xpath("//*[@id='app']/div/main/div/div/div")).getText();
   	    System.out.println(actualText);
   	    Assert.assertEquals(expect_text, actualText);
		}

	
}
