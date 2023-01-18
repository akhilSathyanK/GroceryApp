package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.MobileSliderPage;

public class MobileSliderTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	MobileSliderPage msp;

  @Test(groups = { "SmokeTest", "RegressionTest" })
  public void verifySlideInformationEntry() {
	  lp = new LogInPage(driver);
		hp = new HomePage(driver);
		msp = new MobileSliderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickMobileSliderTab();
		msp.clickNewButton();
		msp.selectCategory();
		msp.chooseImage();
		msp.clickSaveButton();
		String actual=msp.getAlertTesxt();
		String expected="Alert!";
		Assert.assertEquals(actual, expected, Constant.mst_errorVerifySlideInformationEntry);
  }
}
