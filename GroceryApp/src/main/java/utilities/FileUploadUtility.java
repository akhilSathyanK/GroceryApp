package utilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileUploadUtility {
	public void fileUpload(WebDriver driver,WebElement fileUpload) throws AWTException {
		Actions obj = new Actions(driver);
		obj.moveToElement(fileUpload).click().perform();
		
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFiles\\alfaham.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(50);
		robot.keyPress(KeyEvent.VK_CONTROL);  
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(50);
	     
	     robot.keyRelease(KeyEvent.VK_CONTROL); 
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(50);
	     
	     robot.keyPress(KeyEvent.VK_ENTER); 
	     robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
