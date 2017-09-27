package google;

import java.util.List;
import java.util.concurrent.TimeUnit;

import operations.Browser;
import operations.Maximize;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class Sheet {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	Browser bro = new Browser();

	@BeforeMethod
	public void setUp() throws Exception {
		baseUrl = "https://docs.google.com/spreadsheets/d/1-QO4By1yKVTfpTtpNx8etlrZ6xKGPO1DV5BlPuXuoVg/edit#gid=511967756&vpid=A1";
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
		
	    /*driver.findElement(By.id("gb_70")).click();
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("hcl.citrix");
	    driver.findElement(By.id("next")).click();
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("test@1234");
	    driver.findElement(By.id("signIn")).click();*/
		List<WebElement> tab = driver.findElements(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div"));
		   System.out.println("Number of tabs : " + tab.size());
		   for (int i = 0; i < tab.size(); i++) {
		//	WebElement we = tab.get(i);
			if(driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div[" + tab.size() + "]/div/div/div[1]/span")).isDisplayed())
			   {
				   driver.findElement(By.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td[3]/div/div[3]/div/div[" + tab.size() + "]/div/div/div[1]/span")).click();
				   System.out.println("Displayed");
				   Thread.sleep(3000);
				   break;
			   }
			   driver.findElement(By.xpath(".//*[@id=':8']/div/div/div")).click();
			   
		}
	   System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[5]/div[2]/div[1]/div[2]/div[21]/div[2]/div[41]")).getText());
	
	   //driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys(Keys.ESCAPE);
	  // driver.findElement(By.xpath("//*[@id='511967756-scrollable']/div[2]")).sendKeys(Keys.DOWN);
	   driver.findElement(By.xpath("//*[@id='511967756-scrollable']/div[2]")).sendKeys(Keys.ARROW_DOWN);
	   System.out.println("Down : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
	   Thread.sleep(2000);
	   //keystrokes(driver);
	    
	   
	}
	   private void keystrokes(WebDriver driver) {
		// TODO Auto-generated method stub
		   System.out.println("cell data is  : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
		if(driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText().length() ==0)
		{
			keydown(driver);
		}
		else
		{
			keyright(driver);
		}
	}

	private void keyright(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys(Keys.RIGHT);
		 System.out.println("cell data is right : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
		if(driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText().equalsIgnoreCase("Ravi"))
		 {
			 driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys("ravi");
			 keyleft(driver);
		 }
		else
		{
			keyright(driver);
		}
	}

	private void keydown(WebDriver driver) {
		// TODO Auto-generated method stub
		 driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys(Keys.DOWN);
		 System.out.println("cell data is down : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
		 if(!driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText().equalsIgnoreCase("QA Engineer"))
		 {
			 keyright(driver);
		 }
		 else if(driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText().equalsIgnoreCase("Ravi"))
		 {
			 driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys("ravi");
			 keyleft(driver);
		 }
		 
	}

	

	private void keyleft(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys(Keys.LEFT);
		System.out.println("Task Details : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
		
		driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).sendKeys(Keys.LEFT);
		System.out.println("Task : " + driver.findElement(By.xpath(".//*[@id='t-formula-bar-input']/div")).getText());
		
		
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
