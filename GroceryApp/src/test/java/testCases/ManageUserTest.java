package testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageProductPage;
import elementRepository.ManageUserPage;
public class ManageUserTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	ManageProductPage mpp;
	ManageUserPage mup;

	@Test(groups = { "SmokeTest","RegressionTest","SanityTest"})
	public void verifyManageUserPage() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mup = new ManageUserPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManagerUserTab();
		String actual=mup.getListUserText();
		String expected="List Users";
		Assert.assertEquals(actual, expected, Constant.mu_errorVerifyManageUserPageText);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyManageUserPassword() throws Exception {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mup = new ManageUserPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManagerUserTab();
		String actual=mup.clickOnDoenArrowBtnWithDynamicLoc();
		String expected="janakijanani";
		Assert.assertEquals(actual, expected, Constant.mu_errorVerifyManageUserPassword);
	}
}
