package com.ash.pages;

import org.openqa.selenium.By;

import com.ash.utility.BasePage;
import com.ash.utils.waitStrategy;

public class LoginPage extends BasePage {
	// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

	private final By username_textbox = By.xpath("//div//input[@name='username']");
	private final By password_textbox = By.xpath("//div//input[@name='password']");
	private final By loginBtn = By.xpath("//div//button[@type='submit']");

	public LoginPage enterusername() {
		enterValue(username_textbox, waitStrategy.VISIBLE, "Admin");
		return this;

	}

	public LoginPage enterpassword() {
		enterValue(password_textbox, waitStrategy.VISIBLE, "admin123");
		return this;

	}
	//login page

	public LoginPage clickLogin() {
		clickBy(loginBtn, waitStrategy.VISIBLE);
		return this;

	}

}
