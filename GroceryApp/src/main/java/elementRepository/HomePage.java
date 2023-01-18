package elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[3]//a[@class=' nav-link']")
	WebElement clickManageOrders;
	@FindBy(xpath = "//a//p[text()='Manage Product']")
	WebElement clickManageProduct;
	@FindBy(xpath = "//a[text()=' Admin']")
	WebElement adminText;
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrder;
	@FindBy(xpath = "//a[@class=' nav-link']//p[text()='Manage Users']")
	WebElement manageUser;
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(xpath = "//p[text()='Manage Location']")
	WebElement ManageLocation;
	@FindBy(xpath = "//li//p[text()='Manage Slider']")
	WebElement manageSlide;
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	@FindBy(xpath="//a[@class='active nav-link']")
	WebElement dashBord;
	@FindBy(xpath="//div[@style='background-color:green !important;']")
	WebElement dashBoardBackground;
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	@FindBy(xpath="//p[text()='Mobile Slider']")
	WebElement mobileSliderTab;
	

	public String verifyAdminText() {
		return gu.getElementText(adminText);
	}

	public String getManageOrderText() {
		return gu.getElementText(manageOrder);
	}

	public void clickManageOrderfun() {
		clickManageOrders.click();
	}

	public void clickManageProductTab() {
		clickManageProduct.click();
	}

	public void clickManagerUserTab() {
		manageUser.click();
	}

	public void clickPushNotifications() {
		pushNotification.click();
	}

	public void clickManageLocationTab() {
		gu.pageScroll(0, 100, driver);
		ManageLocation.click();
	}

	public void clickManageSlide() {
		gu.pageScroll(0, 100, driver);
		manageSlide.click();
	}
	public String getDashBoardClassName() {
		return dashBord.getAttribute("class");
	}
	public String getBackgGroundColourOfDashBoard() {
		return gu.getCSSValueOfElement(dashBoardBackground, "background-color");
	}
	public void clickAdminUser() {
		gu.pageScroll(0, 100, driver);
		adminUsers.click();
	}
	public void clickMobileSliderTab() {
		mobileSliderTab.click();
	}
}
