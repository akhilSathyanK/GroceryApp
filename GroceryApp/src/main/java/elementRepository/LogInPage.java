package elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
public class LogInPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertText;

	public String logInButtonText() {

		return gu.getElementText(signInButton);
	}

	public void logInHomePage(String userNameIn, String passwordIn) {
		gu.sendKeyFunction(userName, userNameIn);
		gu.sendKeyFunction(password, passwordIn);
		signInButton.click();
	}

	public String readAlertMessage() {
		return gu.getElementText(alertText);
	}
}
