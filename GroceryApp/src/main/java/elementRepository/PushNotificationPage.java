package elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
public class PushNotificationPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[text()='Push Notifications']")
	WebElement pushNotificationHeading;
	@FindBy(id="title")
	WebElement pushTitle;
	@FindBy(id="description")
	WebElement pushDescription;
	@FindBy(xpath="//button[text()=' Send']")
	WebElement pushSendButton;
	@FindBy(xpath="//a[text()='Reset']")
	WebElement pushResetButton;
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alertText;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement headText;
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	WebElement admin;
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']//a[2]")
	WebElement logOut;
	
	public String readPushNotificationPageHeading() {
		return gu.getElementText(pushNotificationHeading);
	}
	
	public void writeTitle(String value) {
		gu.sendKeyFunction(pushTitle, value);
	}
	public void writeDescription(String value) {
		gu.sendKeyFunction(pushDescription, value);
	}
	
	public void clickSendButton() {
		pushSendButton.click();
	}
	public void clickResetButton() {
		pushResetButton.click();
	}
	public String readAlertText() {
		return gu.getElementText(alertText);
	}
	public String readPageHaedingText() {
		return gu.getElementText(headText);
	}
	public void clickOnAdmin() {
		admin.click();
	}
	public void clickOnLogOut() {
		logOut.click();
	}
	public String getAttributeValueOFTitle() {
		return pushTitle.getAttribute("value");
		
	}

}
