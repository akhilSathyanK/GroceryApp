package testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageOrderPage;
public class ManageOrderPageTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	ManageOrderPage mop;

	@Test(groups = {"RegressionTest"})
	public void verifyPaymentMode() {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mop = new ManageOrderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		hp.clickManageOrderfun();
		mop.clickSearchButton();
		String actual = mop.paymentModeDropDownText();
		String expected = "COD";
		Assert.assertEquals(actual, expected, Constant.mop_ErrorVerifyPaymentMode);
	}

	@Test(groups = {"RegressionTest"})
	public void verifySearchListOrders()  {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mop = new ManageOrderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageOrderfun();
		mop.clickSearchButton();
		String actual = mop.searchListOrders();
		String expected = "COD";
		Assert.assertEquals(actual, expected, Constant.mop_ErrorVerifySearchListOrders);
	}

	@Test(groups = {"RegressionTest"})
	public void verifyResetButtonSearchlistOrder()  {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mop = new ManageOrderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageOrderfun();
		mop.clickSearchButton();
		mop.resetButtonClick();
		int actual = mop.getManageOrderTable();
		int expected = 20;
		Assert.assertEquals(actual, expected, Constant.mop_ErrorVerifyResetButtonSearchlistOrder);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyDeleteButtonManageOrder() throws Exception  {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mop = new ManageOrderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageOrderfun();
		mop.clickOnDeleteBtnWithDynamicLoc();
		String actual=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		String expected="Do you want to delete this Order?";
		Assert.assertEquals(actual, expected, Constant.mop_ErrorVerifyDeleteButtonManageOrder);
		
	}
	@Test(groups = {"RegressionTest"})
	public void verifyAmountCorrespondingOrderId() throws Exception  {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mop = new ManageOrderPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageOrderfun();		
		String actual=mop.getAmountCorrespondingOrderIdWithRow();
		String expected="£ 969";
		Assert.assertEquals(actual, expected, Constant.mop_ErrorVerifyAmountCorrespondingOrderId);
	}
}
