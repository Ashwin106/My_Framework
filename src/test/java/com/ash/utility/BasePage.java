package com.ash.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ash.factory.ExplicitWait;
import com.ash.utils.waitStrategy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	 //private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod
	@Parameters("browser")
	public static WebDriver launchBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		return driver;

	}

	protected void clickBy(By by, waitStrategy Wait) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		element.click();
	}

	protected void enterValue(By by, waitStrategy Wait, String value) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		element.sendKeys(value);

	}

	protected void clearValues(By by, waitStrategy Wait) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		element.clear();

	}

	protected String getTextvalue(By by, waitStrategy Wait) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		String text = element.getText();
		return text;

	}

	protected void jsClick(By by, waitStrategy Wait) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
	}

	protected List<String> printSelectvalues(By by, waitStrategy Wait) {
		WebElement element = ExplicitWait.performExplicitWait(Wait, by);
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> seloptions = new ArrayList();
		for (WebElement text : options) {
			String option = text.getText();// user visible values wil be stored
			seloptions.add(option);
		}
		return seloptions;

	}

	public static String selectElementByPartText(WebElement element, By by, String partText) {
		Select select = new Select(element);
		String selectOption = null;
		List<WebElement> list = select.getOptions();
		for (WebElement option : list) {
			String eachOption = option.getText();
			if (eachOption.contains(partText)) {
				select.selectByVisibleText(eachOption);
				selectOption = eachOption;

			}
		}
		return selectOption;

	}

	public static String selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		return visibleText;

	}

}
