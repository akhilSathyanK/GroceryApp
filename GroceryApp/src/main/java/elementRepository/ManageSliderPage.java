package elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class ManageSliderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FileUploadUtility fuu = new FileUploadUtility();
	ExcelUtilities eu = new ExcelUtilities();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[text()='List Sliders']")
	WebElement listSliderText;
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="main_img")
	WebElement chooseFile;
	@FindBy(id="link")
	WebElement link;
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alertText;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveButton;
	
	public String getTitleofTitleBar() {
		return driver.getTitle();
	}
	public String getFontSizeofListSliderText() {
		return gu.getCSSValueOfElement(listSliderText, "font-size");
	}
	public void clickOnHome() {
		home.click();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void selectChooseFile() {
		chooseFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFiles\\alfaham.jpg");
	}
	public void sendLink() {
		gu.sendKeyFunction(link, "www.amazon.in");
	}
	public String getAlertText() {
		return gu.getElementText(alertText);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
}
