package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public void explicitWaitForWebElementText(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	}

	public void explicitWaitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void explicitWaitForAttribute(WebDriver driver, String path, String attribute, String attributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(By.xpath(path), attribute, attributeValue));
	}
	public void fluentWait(WebDriver driver, WebElement element, String attribute, String attributeValue) {
		 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		            .withTimeout(Duration.ofSeconds(30))
		            .pollingEvery(Duration.ofSeconds(2))
		            .ignoring(NoSuchElementException.class);		 
		 fluentWait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));
	}
}
