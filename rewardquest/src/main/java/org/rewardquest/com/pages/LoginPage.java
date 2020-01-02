package org.rewardquest.com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.rewardquest.com.wait.WebDriverWaits;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver = null;
	private WebDriverWaits wait = null;
	private String textError;
	

	@FindBy(how = How.XPATH, using = ".//input[@placeholder='Your Name']")
	private WebElement enterUserName;

	@FindBy(how = How.XPATH, using = ".//input[@placeholder='Password']")
	private WebElement enterPassword;

	@FindBy(how = How.XPATH, using = ".//button[@class='signIn']")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = ".//mat-error")
	WebElement errorMessage;
	
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Rewards Quest')]")
	WebElement rqHeader;
	

	/*
	 * Initialize all the web elements to driver
	 */
	public LoginPage(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			wait = new WebDriverWaits();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Provides valid login credentials
	 */
	public void validLoginCredentials() {
		try {
			wait.waitUntilElementToBeVisible(enterUserName, driver);
			enterUserName.sendKeys("administrator");

			wait.waitUntilElementToBeVisible(enterPassword, driver);
			enterPassword.sendKeys("abc@123");

			wait.waitUntilElementToBeClickable(signIn, driver);
			signIn.click();

			wait.waitUntilElementToBeClickable(rqHeader, driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", rqHeader);
	        System.out.println("Logged In Successfully.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Provides invalid login credentials
	 */
	public void invalidLoginCredentials() {
		try {
			wait.waitUntilElementToBeVisible(enterUserName, driver);
			enterUserName.sendKeys("admin1");

			wait.waitUntilElementToBeVisible(enterPassword, driver);
			enterPassword.sendKeys("abc@123");

			wait.waitUntilElementToBeClickable(signIn, driver);
			signIn.click();

			wait.waitUntilElementToBeVisible(errorMessage, driver);
			textError = errorMessage.getText();
			Assert.assertEquals(textError, "Invalid username or password.");
			System.out.println("Verified testcase with invalid test data.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
