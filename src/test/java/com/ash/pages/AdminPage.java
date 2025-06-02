package com.ash.pages;

import java.util.List;

import org.apache.logging.log4j.core.tools.Generate.ExtendedLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ash.utility.BasePage;
import com.ash.utils.waitStrategy;

public class AdminPage extends BasePage {

	private final By AdminButton = By.xpath("//a//span[text()='Admin']");
	private final By addPerson = By.xpath("//div//button[text()= ' Add ']");
	private final By userRoledropDown = By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
	private final By roleList = By.xpath("(//div[@role='listbox'])[1]");
	private final By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
	private final By userStatusdropDown = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
	private final By username = By
			.xpath("//label[text()='Username']//following::input[@class='oxd-input oxd-input--active'][1]");
	private final By password = By.xpath("(//input[@type='password'])[1]");
	private final By confirmPassword = By.xpath("(//input[@type='password'])[2]");
	private final By saveButton = By.xpath("//button[@type='submit']");

	public AdminPage clickAdmin() {
		clickBy(AdminButton, waitStrategy.VISIBLE);// click on admin button
		return this;
	}

	public AdminPage userRole() throws Exception {

		clickBy(addPerson, waitStrategy.VISIBLE); // click on Add button to create a new role
		clickBy(userRoledropDown, waitStrategy.VISIBLE);
		Thread.sleep(5000);

		WebElement lisofroles = driver.findElement(userRoledropDown);
		String rolestext = lisofroles.getText();
		String[] roles = rolestext.split("\\r?\\n");

		String role = "Admin";

		for (String option : roles) {
			WebElement optionElement = lisofroles.findElement(By.xpath(".//*[contains(text(),'" + role + "')]"));
			optionElement.click();
			break;

		}

		return this;

	}

	public AdminPage employeeName() throws Exception {

		enterValue(employeeName, waitStrategy.VISIBLE, "Tracy  Carson");
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		WebElement namelist = driver.findElement(roleList);
		String nameText = namelist.getText();
		String[] names = nameText.split("\\r\\n");
		String name = "Tracy  Carson";
		for (String option : names) {
			WebElement empname = namelist.findElement(By.xpath(".//*[contains(text(),'" + name + "')]"));
			empname.click();
		}

		return this;

	}

	public AdminPage employeeStatus() throws Exception {
		clickBy(userStatusdropDown, waitStrategy.VISIBLE);
		Thread.sleep(5000);

		WebElement StatusList = driver.findElement(userStatusdropDown);
		String statusText = StatusList.getText();
		String[] roles = statusText.split("\\r?\\n");
		String status = "Enabled";

		for (String option : roles) {
			WebElement optionElement = StatusList.findElement(By.xpath(".//*[contains(text(),'" + status + "')]"));
			optionElement.click();
			break;

		}

		return this;

	}

	public AdminPage userName() {
		enterValue(username, waitStrategy.VISIBLE, "Ashwin");

		return this;

	}

	public AdminPage enterPassword() {
		enterValue(password, waitStrategy.VISIBLE, "Ironman@106");
		return this;

	}

	public AdminPage confirmPassword() {
		enterValue(confirmPassword, waitStrategy.VISIBLE, "Ironman@106");

		return this;

	}

	public AdminPage save() {
		clickBy(saveButton, waitStrategy.VISIBLE);

		return this;
	}

}
