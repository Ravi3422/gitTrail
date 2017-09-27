package google;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import operations.Browser;
import operations.HighLightElement;
import operations.Maximize;
import operations.PageScroll;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

  public class Youtube {
  private RemoteWebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  Browser bro = new Browser();
  
//  @Parameters({ "browse" })
  
@BeforeMethod
@Parameters("browser")
  public void setUp(String browser) throws Exception {
	  baseUrl = "https://www.youtube.com";
      if(browser.equalsIgnoreCase("firefox")){
    	//  driver = bro.firefox();
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
      else if(browser.equalsIgnoreCase("chrome")){
    	  DesiredCapabilities capability = DesiredCapabilities.chrome();
  		capability.setBrowserName("chrome"); 
  		// driver = new ChromeDriver();
  		  driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), capability);
  		
  		//System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
    	
  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
  }
 
   @Test
   public void code() throws InterruptedException {

	   driver.get(baseUrl + "/");
	    
	    Maximize maxi = new Maximize();
	    maxi.maxwin(driver);
	    
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/div/button")).click();
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("ravi.v.gudi");
	    driver.findElement(By.id("next")).click();
	    
	   /* Capture capt = new Capture();
	    capt.takeSS(driver); //Take ScreenShot
	*/    
	    Thread.sleep(1000);
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("mcafee123");
	    driver.findElement(By.id("signIn")).click();
	   
	    //capt.takeSS(driver); //Take ScreenShot
	    
	    driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div/div/div/div/div[2]/div[1]/div[1]/button")).click();
	    PageScroll ps = new PageScroll();
	    try {
			ps.scrollingToBottomofAPage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to scroll");
		}
	   // capt.takeSS(driver); //Take ScreenShot
	    HighLightElement highlight = new HighLightElement();
	    try {
			highlight.elementHighlight(driver, driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[2]/span/button")));
		} catch (Exception e) {
			System.out.println("Element not found to highlight");
		}
	    
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[2]/span/button")).click();
	    
	    //capt.takeSS(driver); //Take ScreenShot
	    Thread.sleep(1000);
	    try {
	    	highlight.elementHighlight(driver,driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/div/div[2]/div/a[2]/span/span")));
	    } catch (Exception e) {
			System.out.println("Element not found to Highlight signout : " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + ((RemoteWebDriver) driver).getCapabilities().getVersion());
		}
	    
	    try {
	    	driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/div/div[5]/a[2]/span")).click();
	    } catch (Exception e) {
			System.out.println("Element not found to signout : " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + ((RemoteWebDriver) driver).getCapabilities().getVersion());
		}
	   // capt.takeSS(driver); //Take ScreenShot
}

 
@AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  @SuppressWarnings("unused")
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
