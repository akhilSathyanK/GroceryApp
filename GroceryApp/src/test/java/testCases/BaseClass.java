package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;

	@DataProvider(name = "data-provider-logIn")
	public Object[][] dpMethod() {
		return new Object[][] { { "anil", "pass" }, { "abc", "12345" }, { "admi2n", "admin" } };
	}

	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	public static String logIndata(int usr) throws IOException {
		ArrayList<String> data = ExcelUtilities.readDataFromExcel("\\src\\main\\resources\\Excel\\grocery.xlsx",
				"login");
		return data.get(usr);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) throws IOException {
		if (browserName.equals("chrome")) {
			testBasic();
			System.setProperty(pro.getProperty("chromeDriver"),
					System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();// run time polymorphims or dynamic method dispatch
		} else if (browserName.equals("edge")) {
			testBasic();
			System.setProperty(pro.getProperty("edgeDriver"),
					System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(pro.getProperty("BaseURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}
}
