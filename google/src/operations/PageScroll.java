package operations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageScroll {
	
	public void scrollingToBottomofAPage(WebDriver driver) throws Exception {
		
		 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollingToElementofAPage(WebDriver driver, WebElement element) throws Exception {
		
		//WebElement element = driver.findElement(By.linkText("element"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollTo(WebDriver driver, WebElement element) throws Exception {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
	
	public void scrollingByCoordinatesofAPageUp(WebDriver driver) throws Exception {

		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
	}
	
	public void scrollingByCoordinatesofAPageDown(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
	}
}
