package elementRepository;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.WaitUtilities;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;
public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FileUploadUtility fuu=new FileUploadUtility();
	ExcelUtilities eu=new ExcelUtilities();
	WaitUtilities wu=new WaitUtilities();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newManageProduct;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> manageProductTable;
	@FindBy(xpath = "//h4[@class='card-title']//b")
	WebElement noOfProduct;
	@FindBy(id = "title")
	WebElement productInformationTitle;
	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement productType;
	@FindBy(id = "cat_id")
	WebElement productInformationCategory;
	@FindBy(xpath="//span//select[@id='sub_id']")
	WebElement subCategory;
	@FindBy(id = "purpose")
	WebElement priceType;
	@FindBy(id = "purpose1")
	WebElement priceTypePiece;
	@FindBy(xpath="//div//label[text()='Minimum Piece ']")
	WebElement minimumPiece;
	@FindBy(id = "m_weight")
	WebElement weightValue;
	@FindBy(id = "w_unit")
	WebElement weightUnit;
	@FindBy(id = "max_weight")
	WebElement maximumQuantityCanOrder;
	@FindBy(id = "w_price")
	WebElement price;
	@FindBy(id = "w_stock")
	WebElement stockAvailability;
	@FindBy(xpath = "//div//label[2]//input[@name='stock']")
	WebElement stockRadioButton;
	@FindBy(xpath = "//div//label[2]//input[@name='featured']")
	WebElement featuredRadioButton;
	@FindBy(xpath = "//div//label[2]//input[@name='combo']")
	WebElement comboPackRadioButton;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
	WebElement alertSuccess;
	@FindBy(id="main_img")
	WebElement chooseImageFile;

			
	public void clickNew() {
		newManageProduct.click();
	}
	public void sendProductInformationTitle() throws IOException {
		gu.sendKeyFunction(productInformationTitle, ExcelUtilities.readDataFromExcel(0, 2, "ManageProduct"));
	}
	public void clickOnProductType() {
		productType.click();
	}
	public void selectProductInformationCategory() {
		gu.selectValueFromDropdown(productInformationCategory, "2");
	}
	public void waitForSubCategory() {
		wu.explicitWaitForAttribute(driver, "//span//select[@id='sub_id']", "id", "sub_id");
	}
	public void waitForMinimumPiece() {
		wu.fluentWait(driver, minimumPiece, "for", "mini_wgt");
	}
	public void selectProductInformationSubCategory() {
		gu.selectValueFromDropdown(subCategory, "10");
	}
	public void clickOnProductPieceType() {
		priceTypePiece.click();
	}
	public void clickOnPriceType() {
		priceType.click();
	}
	public void sendWeightValueToPriceType() {
		gu.sendKeyFunction(weightValue, "52");
	}
	public void selectWeightUnit() {
		gu.selectValueFromDropdown(weightUnit, "g");
	}
	public void sendMaximumQuantityCanOrde() {
		gu.sendKeyFunction(maximumQuantityCanOrder, "100");
	}
	public void sendPrice() {
		gu.sendKeyFunction(price, "23");
	}
	public void sendStockAvailability() {
		gu.sendKeyFunction(stockAvailability, "65");
	}
	public void clicStockRadioButton() {
		stockRadioButton.click();
	}
	public void clickComboPackRadioButton() {
		comboPackRadioButton.click();
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public String getAlertSuccessMessage() {
		return gu.getElementText(alertSuccess);
	}
	public void uploadImageFile() throws AWTException {
		fuu.fileUpload(driver, chooseImageFile);               
	}
	public int getTableSize() {
		return manageProductTable.size();
	}

	public String getNoOfProductList() {
		String str= noOfProduct.getText();
		return str.substring(1, str.length() - 1);
	}
	public String getMinimumPieceText() {
		return gu.getElementText(minimumPiece);
	}
}
