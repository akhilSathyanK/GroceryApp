package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectIndexFromDropdown(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void sendKeyFunction(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}

	public void sendKeyFunctionforImage(WebElement element, String imageName) {
		element.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\UploadFiles\\" + imageName);
	}

	public String selectValueFromDynamicTable(List<WebElement> listOfRow, String value, String locator) {

		String elementLocator = null;
		for (int i = 0; i < listOfRow.size(); i++) {
			if (listOfRow.get(i).getText().equals(value)) {
				elementLocator = locator;
				break;
			}
		}
		return elementLocator;
	}

	public int selectRowFromDynamicTable(List<WebElement> listOfRow, String value) throws Exception {

		int j = 0;
		for (int i = 0; i < listOfRow.size(); i++) {

			if (listOfRow.get(i).getText().equals(value)) {
				j = i;
				break;
			}

			else if (i == listOfRow.size()) {

				throw new ArithmeticException("value not present ");
			}
		}

		return j;

	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void pageScroll(int horizontal, int vertical, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");

	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String getCSSValueOfElement(WebElement element, String parameter) {
		return element.getCssValue(parameter);
	}

}
