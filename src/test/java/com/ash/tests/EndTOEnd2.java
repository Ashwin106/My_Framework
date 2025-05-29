package com.ash.tests;

import org.testng.annotations.Test;

import com.ash.pages.AdminPage;
import com.ash.pages.LoginPage;
import com.ash.utility.BasePage;

public class EndTOEnd2 extends BasePage{
	@Test
	public void endTOend() throws Exception {
//		launchBrowser(null);

		new LoginPage().enterusername().enterpassword().clickLogin();

		// Adfmin page
		new AdminPage().clickAdmin().userRole().
		//employeeName().
		employeeStatus();
		
	}

}
