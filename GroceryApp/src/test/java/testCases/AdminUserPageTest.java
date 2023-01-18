package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUserPage;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import utilities.GeneralUtilities;

public class AdminUserPageTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	AdminUserPage aup;
	GeneralUtilities gu; 

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void verifyNewUserWithRandom() {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		aup = new AdminUserPage(driver);
		gu= new GeneralUtilities();
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickAdminUser();
		aup.clickNewButton();
		aup.sendUserName();
		aup.sendPassword();
		aup.waitForUserType();
		aup.selectUserType();
		aup.clickSaveButton();
		aup.waitForAlertText();
		String actual=aup.getAlertMessage();
		
		String expected="Alert!";
		Assert.assertEquals(actual, expected, Constant.aup_errorVerifyNewUserWithRandom);
	}
}
