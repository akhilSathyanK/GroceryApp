package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
public class ManageOrderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//div[2]//select[@id='pt']")
	WebElement paymentModeDropDown;
	@FindBy(id = "od")
	WebElement orderId;
	@FindBy(id = "sd")
	WebElement startDate;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchListButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]")
	WebElement paymentModeTextfromTable;
	@FindBy(xpath = "//button[@class='btn btn-default btn-fix']")
	WebElement resetButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageOrderTable;

	public void clickSearchButton() {
		searchButton.click();
	}

	public String paymentModeDropDownText() {
		String paymentText = gu.selectValueFromDropdown(paymentModeDropDown, "Cash on Delivery");
		return paymentText;
	}

	public String searchListOrders() {
		gu.sendKeyFunction(orderId, "376");
		gu.sendKeyFunction(startDate, "15-04-2021");
		searchListButton.click();
		return gu.getElementText(paymentModeTextfromTable);

	}

	public void resetButtonClick() {
		gu.sendKeyFunction(orderId, "402");
		searchListButton.click();
		resetButton.click();
	}

	public int getManageOrderTable() {
		return manageOrderTable.size();
	}
	public void clickOnDeleteBtnWithDynamicLoc() throws Exception {

		List<WebElement> columnlist = manageOrderTable;
		WebElement deleteButton;		
		gu.pageScroll(0, 500, driver);
		gu.mediumDelay();
		int rowNumber= gu.selectRowFromDynamicTable(columnlist, "383");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber+1) +"]//td[7]//child::a[2]";
		deleteButton = driver.findElement(By.xpath(locator));
		gu.clickJavaScriptExecutor(deleteButton, driver);
		gu.mediumDelay();
	}
	public String getAmountCorrespondingOrderIdWithRow() throws Exception {
		WebElement amount;	
		gu.pageScroll(0, 250, driver);
		gu.mediumDelay();
		int rowNumber=gu.selectRowFromDynamicTable(manageOrderTable, "386");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (rowNumber+1)+ "]//td[4]";		
		amount = driver.findElement(By.xpath(locator));		
		return amount.getText();
	}
}
