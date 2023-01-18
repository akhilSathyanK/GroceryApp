package testCases;

import org.testng.annotations.Test;

import constant.Constant;

import java.io.IOException;

import org.testng.Assert;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.PushNotificationPage;
import utilities.GeneralUtilities;

public class PushNotificationTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	PushNotificationPage pnp;
	GeneralUtilities gu;

	@Test(groups = { "RegressionTest", "SanityTest" })
	public void verifyPushNotificationSend() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pnp = new PushNotificationPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickPushNotifications();
		pnp.writeTitle("Manage");
		pnp.writeDescription("not working");
		pnp.clickSendButton();
		String actual = pnp.readAlertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.pn_errorVerifyPushNotificationSend);
	}

	@Test(groups = { "SmokeTest", "RegressionTest" })
	public void verifyPageHeading() {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pnp = new PushNotificationPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickPushNotifications();
		String actual = pnp.readPageHaedingText();
		String expected = "Push Notifications";
		Assert.assertEquals(actual, expected, Constant.pn_errorVerifyPageHeading);
	}

	@Test(groups = { "SmokeTest", "RegressionTest" })
	public void verifyLogOut() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pnp = new PushNotificationPage(driver);
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickPushNotifications();
		pnp.clickOnAdmin();
		pnp.clickOnLogOut();
		String actual = lp.logInButtonText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, Constant.pn_errorVerifyLogOut);
	}

	@Test(groups = { "SmokeTest", "RegressionTest", "SanityTest" })
	public void verifyPushNotificationReset() throws IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pnp = new PushNotificationPage(driver);
		gu = new GeneralUtilities();
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickPushNotifications();
		pnp.writeTitle("Manage");
		pnp.writeDescription("not working");
		System.out.println(pnp.getAttributeValueOFTitle());
		pnp.clickResetButton();
		try {
			gu.mediumDelay();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(pnp.getAttributeValueOFTitle());
		String actual = pnp.getAttributeValueOFTitle();
		String expected = "";
		Assert.assertEquals(actual, expected, Constant.pn_errorVerifyPushNotificationReset);
	}
}