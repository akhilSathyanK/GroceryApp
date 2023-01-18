package testCases;

import org.testng.annotations.Test;

import constant.Constant;

import java.io.IOException;

import org.testng.Assert;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageLocationPage;
import utilities.GeneralUtilities;

public class ManageLocationTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	GeneralUtilities gu;
	ManageLocationPage mlp;

	@Test(groups = "SanityTest")
	public void verifyActiveInactiveStatus() throws Exception {
		String expected = null;
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mlp = new ManageLocationPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageLocationTab();
		String actual;
		actual = mlp.getActiveInactiveText();
		if (actual.equals("Active")) {
			expected = "Active";
		} else if (actual.equals("Inactive")) {
			expected = "Inactive";
		}
		Assert.assertEquals(actual, expected, Constant.ml_aup_errorVerifyActiveInactiveStatus);
	}
}
