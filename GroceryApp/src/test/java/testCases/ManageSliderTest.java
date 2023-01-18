package testCases;

import org.testng.annotations.Test;

import constant.Constant;

import java.io.IOException;

import org.testng.Assert;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageSliderPage;
public class ManageSliderTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	ManageSliderPage msp;

	@Test(groups = { "SmokeTest","RegressionTest"})
	public void verifyTitleBar() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		msp = new ManageSliderPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageSlide();
		String actual=msp.getTitleofTitleBar();
		String expected="List Sliders | 7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.ms_errorVerifyTitleBar);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyFontSize() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		msp = new ManageSliderPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageSlide();
		String actual=msp.getFontSizeofListSliderText();
		String expected="1.8rem";
		Assert.assertEquals(actual, expected, Constant.ms_errorVerifyFontSize);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyAddNewSlider()  {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		msp = new ManageSliderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageSlide();
		msp.clickNewButton();
		msp.selectChooseFile();
		msp.sendLink();
		msp.clickSaveButton();
		String actual=msp.getAlertText();
		String expected="Alert!";
		Assert.assertEquals(actual, expected, Constant.ms_errorVerifyAddNewSlider);
	}
}
