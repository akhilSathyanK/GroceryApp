package testCases;

import org.testng.annotations.Test;

import constant.Constant;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageProductPage;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class ManageProductPageTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	ManageProductPage mpp;
	GeneralUtilities gu;
	FileUploadUtility fuu;

	@Test(groups = {"RegressionTest"})
	public void verifyManageProductTableSize() {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mpp = new ManageProductPage(driver);
		try {
			lp.logInHomePage(logIndata(0), logIndata(1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hp.clickManageProductTab();
		String actual = mpp.getNoOfProductList();		
		String expaected = "(854)";
		Assert.assertEquals(actual, expaected, Constant.mpp_errorVerifyManageProductTableSize);
	}

	@Test(groups = {"RegressionTest"})
	public void verifyNewManageProduct() throws InterruptedException, IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mpp = new ManageProductPage(driver);
		gu = new GeneralUtilities();
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageProductTab();
		mpp.clickNew();
		mpp.sendProductInformationTitle();
		mpp.clickOnProductType();
		mpp.selectProductInformationCategory();
		gu.mediumDelay();
		mpp.selectProductInformationSubCategory();
		mpp.clickOnPriceType();
		mpp.sendWeightValueToPriceType();
		mpp.selectWeightUnit();
		mpp.sendMaximumQuantityCanOrde();
		mpp.sendPrice();
		mpp.sendStockAvailability();
		gu.pageScroll(0, 9000, driver);
		gu.mediumDelay();
		mpp.clicStockRadioButton();
		mpp.clickComboPackRadioButton();
		mpp.clickOnSaveButton();
		String actual = mpp.getAlertSuccessMessage();
		String expaected = "Alert!";
		Assert.assertEquals(actual, expaected, Constant.mpp_errorVerifyManageUserPassword);
	}

	@Test(groups = {"RegressionTest"})
	public void verifyNewManageProductWithImage() throws InterruptedException, IOException, AWTException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mpp = new ManageProductPage(driver);
		gu = new GeneralUtilities();
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageProductTab();
		mpp.clickNew();
		mpp.sendProductInformationTitle();
		mpp.clickOnProductType();
		mpp.selectProductInformationCategory();
		gu.mediumDelay();
		mpp.selectProductInformationSubCategory();
		mpp.clickOnPriceType();
		mpp.sendWeightValueToPriceType();
		mpp.selectWeightUnit();
		mpp.sendMaximumQuantityCanOrde();
		mpp.sendPrice();
		mpp.sendStockAvailability();
		gu.pageScroll(0, 9000, driver);
		gu.mediumDelay();
		mpp.clicStockRadioButton();
		mpp.uploadImageFile();
		gu.mediumDelay();
		mpp.clickComboPackRadioButton();
		mpp.clickOnSaveButton();
		String actual = mpp.getAlertSuccessMessage();
		String expaected = "Alert!";
		Assert.assertEquals(actual, expaected, Constant.mpp_errorVerifyNewManageProductWithImage);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyNewManageProductWithExplisitWait() throws InterruptedException, IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mpp = new ManageProductPage(driver);
		gu = new GeneralUtilities();
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageProductTab();
		mpp.clickNew();
		mpp.sendProductInformationTitle();
		mpp.clickOnProductType();
		mpp.selectProductInformationCategory();
		mpp.waitForSubCategory();
		mpp.selectProductInformationSubCategory();
		mpp.clickOnPriceType();
		mpp.sendWeightValueToPriceType();
		mpp.selectWeightUnit();
		mpp.sendMaximumQuantityCanOrde();
		mpp.sendPrice();
		mpp.sendStockAvailability();
		gu.pageScroll(0, 9000, driver);
		gu.mediumDelay();
		mpp.clicStockRadioButton();
		mpp.clickComboPackRadioButton();
		mpp.clickOnSaveButton();
		String actual = mpp.getAlertSuccessMessage();
		String expaected = "Alert!";
		Assert.assertEquals(actual, expaected, Constant.mpp_errorVerifyNewManageProductWithExplisitWait);
	}
	@Test(groups = {"RegressionTest"})
	public void verifyPriceTypePiece() throws InterruptedException, IOException {
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		mpp = new ManageProductPage(driver);
		gu = new GeneralUtilities();
		lp.logInHomePage(logIndata(0), logIndata(1));
		hp.clickManageProductTab();
		mpp.clickNew();
		gu.pageScroll(0, 9000, driver);
		mpp.clickOnProductPieceType();
		mpp.waitForMinimumPiece();
		gu.pageScroll(0, 9000, driver);		
		String actual = mpp.getMinimumPieceText();
		String expaected = "Minimum Piece";
		Assert.assertEquals(actual, expaected, Constant.mpp_errorVerifyPriceTypePiece);
	}
	
}
