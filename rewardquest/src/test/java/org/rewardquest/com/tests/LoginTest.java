package org.rewardquest.com.tests;

import org.testng.annotations.Test;
import org.rewardquest.com.base.Base;
import org.rewardquest.com.pages.LoginPage;

public class LoginTest extends Base {

	public LoginPage login = null;

	@Test(priority=1)
	public void loginWithValidCredentials() {
		login = new LoginPage(driver);
		login.validLoginCredentials();
	}
	
	@Test(priority=2)
	public void loginWithInValidCredentials() {
		login = new LoginPage(driver);
		login.invalidLoginCredentials();
	}
}
