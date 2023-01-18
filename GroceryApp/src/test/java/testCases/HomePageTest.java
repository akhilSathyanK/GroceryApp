package testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageSliderPage;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LogInPage lp;
	ManageSliderPage msp;

	@Test(groups = "RegressionTest",priority=2)
	public void verifyManageOrderText() {
		hp = new HomePage(driver);
		lp = new LogInPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = hp.getManageOrderText();
		String expected = "Manage Orders";
		Assert.assertEquals(actual, expected, Constant.hp_errorVerifyManageOrderText);
	}
	@Test(groups = {"SmokeTest","RegressionTest"},priority=1)
	public void verifyNavigateToHomePage()  {
		hp = new HomePage(driver);
		lp = new LogInPage(driver);
		msp=new ManageSliderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageSlide();
		msp.clickOnHome();
		String actual = hp.getDashBoardClassName();
		String expected = "active nav-link";
		Assert.assertEquals(actual, expected, Constant.hp_errorverifyNavigateToHomePage);
	}
	@Test(groups = { "RegressionTest"},priority=3)
	public void verifyBackgroundColourOfDashBoard()  {
		hp = new HomePage(driver);
		lp = new LogInPage(driver);
		msp=new ManageSliderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = hp.getBackgGroundColourOfDashBoard();
		String expected = "green !important";
		Assert.assertEquals(actual, expected, Constant.hp_errorVerifyBackgroundColourOfDashBoard);
	}
}
