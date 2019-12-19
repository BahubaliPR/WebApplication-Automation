package org.rewardquest.com.tests;

import org.testng.annotations.Test;
import org.rewardquest.com.base.Base;
import org.rewardquest.com.pages.LoginPage;

public class LoginTest extends Base {

	public LoginPage login = null;

	@Test
	public void performPracticeTable() {
		login = new LoginPage(driver);
		login.getDataFromTheTable();
	}
}
