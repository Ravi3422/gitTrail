package website;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import operations.Browser;
import operations.Capture;
import operations.HighLightElement;
import operations.Maximize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Makemytrip {
	 private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  Browser bro = new Browser();
	  
	  //@Parameters({ "browse" })
	  
	@BeforeMethod
	  public void setUp() throws Exception {
		  baseUrl = "http://www.makemytrip.com";
	  }

	   @Test
	  public void firefox() throws Exception {
		   driver = bro.chrome();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   code();
	 }
	   public void code() throws InterruptedException {

		   driver.get(baseUrl + "/");
		    
		    Maximize maxi = new Maximize();
		    maxi.maxwin(driver);
		    
		    HighLightElement high = new HighLightElement();
		    try {
				high.elementHighlight(driver, driver.findElement(By.id("from_typeahead1")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Cannot find the from textbox");
			}
		    driver.findElement(By.id("from_typeahead1")).clear();
		    driver.findElement(By.id("from_typeahead1")).click();
		    Thread.sleep(2000);
		    
		    /*List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='one_round_default']/div/div/div/div/span/span/div/span/div"));
		    System.out.println("Number of items: " +allElements.size());
		    for (WebElement ele : allElements)
		    {
		    	System.out.println(ele.getText());
		    }*/
		    
		    System.out.println(driver.findElement(By.xpath("//*[@id='deals_carousel']/div/div[3]/a/img")).getAttribute("src"));
		    Capture cpt = new Capture();
		    try {
				cpt.specific_SS(driver, driver.findElement(By.xpath("//*[@id='chf_header']/div[1]/div/div[1]/p/a[1]")));
				cpt.specific_SS(driver, driver.findElement(By.xpath("//*[@id='chf_header']/div[1]/div/div[1]/p/a[2]")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    /*
		    //driver.findElement(By.id("from_typeahead1")).sendKeys("Bangalore");
		    driver.findElement(By.xpath("//div[@id='one_round_default']/div/div/div/div/span/span/div/span/div[3]/p")).click();

		    driver.findElement(By.id("to_typeahead1")).clear();
		    driver.findElement(By.id("to_typeahead1")).sendKeys("Chennai");
		    
		    driver.findElement(By.id("start_date_sec")).click();
		    driver.findElement(By.id("flights_submit")).click();
		    Thread.sleep(2000);
		    System.out.println("Message displayed : " + driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[3]/div/div[3]/div")).getText());
*/	   }
	   @AfterMethod
	   public void tearDown() throws Exception {
	     driver.quit();
	     String verificationErrorString = verificationErrors.toString();
	     if (!"".equals(verificationErrorString)) {
	       Assert.fail(verificationErrorString);
	     }
	   }
}
