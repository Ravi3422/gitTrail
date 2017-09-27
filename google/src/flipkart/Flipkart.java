package flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import operations.Browser;
import operations.HighLightElement;
import operations.Maximize;
import operations.PageScroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart {
	 private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  Browser bro = new Browser();
	  
	  //@Parameters({ "browse" })
	  
	@BeforeMethod
	  public void setUp() throws Exception {
		  baseUrl = "https://www.flipkart.com";
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
		    
		    try{
		    	driver.findElement(By.xpath("html/body/div[8]/div[2]/span")).click();
		    }
		    catch (Exception e){
		    	System.out.println("No Pop up");
		    }
		    List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='fk-mainbody-id']/div/div[2]/div[1]/div[1]/div[8]/div[4]/div[4]/div/div[1]/a"));
		    System.out.println("Number of items: " +tabs.size());
		    for (int i = 1; i <= tabs.size(); i++) {
				List<WebElement> data = driver.findElements(By.xpath("//div[@id='fk-mainbody-id']/div/div[2]/div[1]/div[1]/div[8]/div[4]/div[4]/div/div["+(i+1)+"]"));
			    for(WebElement elem:data){
			        System.out.println(elem.getAttribute("id"));
			       // String xpath_id = elem.getAttribute("id");
			      //  driver.findElement(By.id(xpath_id)).click();
			      //  content(xpath_id);
			        Thread.sleep(2000);
			       
			}
			}
		    
		//    content("hp_category_tab_homeliving_0-content");
		   /* content("hp_category_tab_electronics_0-content");
		    content("hp_category_tab_rest_0-content");
		    content("hp_category_tab_lifestyle_0-content");*/
	   }
	   
	   public void content(String id)
	   {
		   // Scroll the page to specified point
		   PageScroll ps = new PageScroll();
		   try {
				ps.scrollingToElementofAPage(driver,driver.findElement(By.xpath("//div[@id='" + id +"']")));
			} catch (Exception e) {
				System.out.println("Unable to scroll");
			}
		    
		    String page_items = driver.findElement(By.xpath("//div[@id='" + id +"']/div[1]")).getAttribute("data-columns");
		    
		    HighLightElement highlight = new HighLightElement();

		    List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='" + id +"']/div[1]/div/div/div/div/ul/li"));
		    System.out.println("Number of items: " +allElements.size());
		    for (int i=1;i<=allElements.size();i++)
		    {
		    	
		    	try {
					highlight.elementHighlight(driver, driver.findElement(By.xpath("//div[@id='" + id +"']/div[1]/div/div/div/div/ul/li["+i+"]/div/div")));
				} catch (Exception e) {
					System.out.println("Element not found to highlight : " + "//div[@id='" + id +"']/div[1]/div/div/div/div/ul/li["+i+"]/div/div");
				}
		    	if ((i%Integer.parseInt(page_items))==0)
		    	{
		    		driver.findElement(By.xpath("//div[@id='" + id +"']/div[1]/div/div/a[2]")).click();
		    		System.out.println("Moving to page : " + i/4);
		    	}
		    	//System.out.println("@ element : " + i);
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
