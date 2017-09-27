package operations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLightElement {
	//WebDriver driver;
	public void elementHighlight(WebDriver driver, WebElement element) throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 5px solid yellow;");
			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
	}

}
