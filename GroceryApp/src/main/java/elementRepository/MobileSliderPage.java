package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class MobileSliderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FileUploadUtility fuu = new FileUploadUtility();
	ExcelUtilities eu = new ExcelUtilities();

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="select#cat_id")
	WebElement categoryDropDown;
	@FindBy(css="input#main_img")
	WebElement chooseFile;
	@FindBy(css="button[class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(css="div[class='alert alert-success alert-dismissible']>h5")
	WebElement alertText;
	@FindBy(css="a[class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	public void selectCategory() {
		gu.selectIndexFromDropdown(categoryDropDown, 2);
	}
	public void chooseImage() {
		gu.sendKeyFunctionforImage(chooseFile, "momo.jpg");
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public String getAlertTesxt() {
		return gu.getElementText(alertText);
	}
	public void clickNewButton() {
		newButton.click();
	}
	
}
