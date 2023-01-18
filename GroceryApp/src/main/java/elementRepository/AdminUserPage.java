package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.RandomDataUtilities;
import utilities.WaitUtilities;

public class AdminUserPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	RandomDataUtilities rdu=new RandomDataUtilities();
	WaitUtilities wu =new WaitUtilities();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath="//div//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userTypeDrop;
	@FindBy(xpath="//div[@class='card-footer center']//button")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText1;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")//h5[text()='Alert!'
	WebElement alertText;
	
	public void clickNewButton() {
		newButton.click();
	}
	public void sendUserName() {
		gu.sendKeyFunction(userName,"@qwerty"+rdu.randon());
	}
	public void sendPassword() {
		gu.sendKeyFunction(password, "password"+rdu.randon());
	}
	public void selectUserType() {
		gu.selectIndexFromDropdown(userTypeDrop, 2);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public String getAlertMessage() {
		return gu.getElementText(alertText);
	}
	public void waitForUserType() {
		wu.fluentWait(driver, userTypeDrop, "class", "form-control");
	}
	public void waitForAlertText() {
		wu.fluentWait(driver, alertText1, "class", "alert alert-success alert-dismissible");
	}
	
}
