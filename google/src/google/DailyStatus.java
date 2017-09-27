package google;

import java.util.List;
import java.util.concurrent.TimeUnit;

import operations.Browser;
import operations.Maximize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DailyStatus {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	Browser bro = new Browser();

	@BeforeMethod
	public void setUp() throws Exception {
		baseUrl = "https://docs.google.com/spreadsheets/d/1-QO4By1yKVTfpTtpNx8etlrZ6xKGPO1DV5BlPuXuoVg/edit#gid=1793391261";
	}

	@Test
	public void firefox() throws Exception {
		driver = bro.firefox();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		code();
	}

	public void code() throws InterruptedException {

		driver.get(baseUrl + "/");

		Maximize maxi = new Maximize();
		maxi.maxwin(driver);
		
		//Sign In
		
	   /* driver.findElement(By.id("gb_70")).click();
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("hcl.citrix");
	    driver.findElement(By.id("next")).click();
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("test@1234");
	    driver.findElement(By.id("signIn")).click();*/
	  // webele();
	   List<WebElement> tab = driver.findElements(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div"));
	   System.out.println("Number of tabs : " + tab.size());
	   for (@SuppressWarnings("unused") WebElement we : tab)
	   {
		   if(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div[" + tab.size() + "]/div/div/div[1]/span")).isDisplayed())
		   {
			   driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div[" + tab.size() + "]/div/div/div[1]/span")).click();
			   System.out.println("Displayed");
			   Thread.sleep(3000);
			   break;
		   }
		   driver.findElement(By.xpath(".//*[@id=':8']/div/div/div")).click();
	   }
	   System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[5]/div[2]/div[1]/div[2]")).getText());
	    Thread.sleep(2000);
	}

	public void  webele() {
		 List<WebElement> tabs = driver.findElements(By.xpath("//*[@id='grid-bottom-bar']/tbody/tr[2]/td[3]/div/div[3]/div"));
		    System.out.println(tabs.size());
		    for (WebElement we : tabs)
		    {
		    	
		    	if(!we.getText().contains("EOD"))
		    	{
		    		driver.findElement(By.xpath(".//*[@id=':8']/div/div/div")).click();
		    		System.out.println(we.getText());
		    		webele();
		    	}
		    	else
		    	{
		    		System.out.println("Found : " + we.getTagName());
		    		//System.out.println("ID : "+ driver.findElement(By.tagName("EOD")).getText());
		    		System.out.println(we.getClass().getName());
		    	}
		    }
		    
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
