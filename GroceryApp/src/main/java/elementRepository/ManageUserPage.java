package elementRepository;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUserPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageUserTable;
	@FindBy(xpath = "//span[text()='janakijanani']")
	WebElement manageUserPassword;
	@FindBy(xpath = "//h1[text()='List Users']")
	WebElement listUserText;

	public String getListUserText() {
		return gu.getElementText(listUserText);
	}

	public void clickArrowPasswordIcon() {

	}

	public String clickOnDoenArrowBtnWithDynamicLoc() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		gu.mediumDelay();
		int  rowNumber= gu.selectRowFromDynamicTable(manageUserTable, "sree sree");
		String downLocator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber+1) +"]//td[3]//a";
		WebElement manageUserDownIcon = driver.findElement(By.xpath(downLocator));
		gu.mediumDelay();
		gu.clickJavaScriptExecutor(manageUserDownIcon, driver);
		gu.mediumDelay();
		int rowNumber1 = gu.selectRowFromDynamicTable(manageUserTable, "sree sree");				
		String passwordLocator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber1+2) +"]//td//div//div//span[text()='janakijanani']";
		WebElement manageUserPassword = driver.findElement(By.xpath(passwordLocator));		
		return manageUserPassword.getText();
	}

}
