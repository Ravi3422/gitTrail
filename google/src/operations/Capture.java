package operations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Capture {

	public void takeSS(WebDriver driver) {
		// TODO Auto-generated method stub
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        caln(f);
	}
	
	 public void specific_SS(WebDriver driver, WebElement ele) throws IOException
     {
		 File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 BufferedImage  fullImg = ImageIO.read(screenshot);
		 //Get the location of element on the page
		 Point point = ele.getLocation();
		 //Get width and height of the element
		 int eleWidth = ele.getSize().getWidth();
		 int eleHeight = ele.getSize().getHeight();
		 
		 //Crop the entire page screenshot to get only element screenshot
		 System.out.println("X : " + point.getX() + "  Y : " + point.getY() + "  width : " + eleWidth + "  Height : " + eleHeight + "  capt width : " + fullImg.getWidth() + "  capt height : " + fullImg.getHeight());
		 BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,eleHeight);
		 ImageIO.write(eleScreenshot, "png", screenshot);
		 //Copy the element screenshot to disk
		 caln(screenshot);
		 //FileUtils.copyFile(screenshot, new File("c:\\images\\GoogleLogo_screenshot.png"));
     }
	 
	 public void caln(File f) {
		 try {
	        	
	        	Calendar cal = Calendar.getInstance();
	            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HHmmss");
	            System.out.println( sdf.format(cal.getTime()) );
	        	
	        	/*Date date = new Date();
	        	String dt = (date.getDate()+"_"+date.getMonth()+"_"+date.getYear()+"_"+date.getHours()+"_"+date.getMinutes()+"_"+date.getSeconds());
	        	System.out.println(date.getTime())*/;
				FileUtils.copyFile(f, new File("ScreenShot/SS_"+sdf.format(cal.getTime())+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

}
