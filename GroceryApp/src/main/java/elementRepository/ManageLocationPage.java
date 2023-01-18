package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageLocationTable;

	public String getActiveInactiveText() throws Exception {
		WebElement activeInactive, activeInactiveText;
		gu.pageScroll(0, 50, driver);
		gu.mediumDelay();
		int rowNumber;
		rowNumber = gu.selectRowFromDynamicTable(manageLocationTable, "london");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowNumber + 1)
				+ "]//td[5]//a";
		activeInactive = driver.findElement(By.xpath(locator));
		activeInactive.click();
		String locatorText = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowNumber + 1)
				+ "]//td[5]";
		activeInactiveText = driver.findElement(By.xpath(locatorText));
		gu.mediumDelay();
		return activeInactiveText.getText();// utitlty
	}

}
