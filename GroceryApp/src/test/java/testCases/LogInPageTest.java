package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;

public class LogInPageTest extends BaseClass {
	LogInPage lp;
	HomePage hp;

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "anil", "pass" }, { "abc", "12345" }, { "admi2n", "admin" } };
	}

	@Test(groups = { "SmokeTest","RegressionTest","SanityTest"})
	public void verifySignInText() {
		lp = new LogInPage(driver);
		String actual = lp.logInButtonText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, Constant.lp_errorVerifySignInText_LP);
	}

	@Test(groups = { "SmokeTest","RegressionTest","SanityTest"},priority=2)
	public void verifyLogInHomePage() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		String actual = hp.verifyAdminText();
		String expected = "Admin";
		Assert.assertEquals(actual, expected, Constant.lp_errorMessageVerifyLoginHomePage);
	}

	@Test(groups =  "SmokeTest")
	public void verifyLogInInvalid() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		lp.logInHomePage(logIndata(2), logIndata(3));
		String actual = lp.readAlertMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.lp_errorMessageVerifyInvalidLogin);
	}

	@Test(dataProvider = "data-provider",groups= "RegressionTest",priority=1)
	public void verifyLogInInvalidWithDataProvider(String userName, String password) {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		lp.logInHomePage(userName, password);
		String actual = lp.readAlertMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInInvalidWithDataProvider);
	}

	@Test(dataProvider = "data-provider-logIn", dataProviderClass = BaseClass.class,groups= "RegressionTest")
	public void verifyLogInInvalidWithDataProviderWithAnotherClass(String userName, String password) {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		lp.logInHomePage(userName, password);
		String actual = lp.readAlertMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInInvalidWithDataProviderWithAnotherClass);
	}

}
