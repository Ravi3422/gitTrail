package operations;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	public WebDriver chrome() throws MalformedURLException{
		
		
		System.setProperty("webdriver.chrome.driver", "H:\\chromedriver.exe");
		 
		return new ChromeDriver();
	}
	 public WebDriver firefox(){
		 return new FirefoxDriver();
		
	 }
	 
	 public WebDriver IE() throws IOException{
		 System.setProperty("webdriver.ie.driver", "C:/Users/t_ravigud/workspace/IEDriverServer_x64_2.48.0/IEDriverServer.exe");
		 Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		 return new InternetExplorerDriver();
	 }
	 
	 public WebDriver safari() throws IOException{
		 System.setProperty("SafariDefaultPath", "C:\\Program Files (x86)\\Safari\\Safari.exe");
	  System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
	  return new SafariDriver();
	 }
	public WebDriver chrome_default() {
		System.setProperty("webdriver.chrome.driver", "C:/RAVI/personal/eclipse_standard/chromedriver_win32/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
		//WebDriver driver = new ChromeDriver(capabilities);
		return new ChromeDriver(capabilities);
	}
}
