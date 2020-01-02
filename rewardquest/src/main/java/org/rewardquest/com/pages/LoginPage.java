package org.rewardquest.com.pages;

import org.apache.log4j.Logger;
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
	public static final Logger log = Logger.getLogger(LoginPage.class);

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
			wait.waitUntilPageLoad(driver);
			wait.waitUntilElementToBeVisible(enterUserName, driver);
			enterUserName.sendKeys("administrator");
			log.info("Entered user name.");

			wait.waitUntilElementToBeVisible(enterPassword, driver);
			enterPassword.sendKeys("abc@123");
			log.info("Entered user password.");

			wait.waitUntilElementToBeClickable(signIn, driver);
			signIn.click();
			log.info("clicked on sign in button.");

			wait.waitUntilElementToBeClickable(rqHeader, driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					rqHeader);
			log.info("Logged In Successfully.\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Provides invalid login credentials
	 */
	public void invalidLoginCredentials() {
		try {
			wait.waitUntilElementToBeClickable(enterUserName, driver);
			wait.waitUntilElementToBeVisible(enterUserName, driver);
			enterUserName.sendKeys("admin1");
			log.info("Entered invalid user name.");

			wait.waitUntilElementToBeVisible(enterPassword, driver);
			enterPassword.sendKeys("abc@123");
			log.info("Entered user password.");

			wait.waitUntilElementToBeClickable(signIn, driver);
			signIn.click();
			log.info("clicked on sign in button.");

			wait.waitUntilElementToBeClickable(errorMessage, driver);
			wait.waitUntilElementToBeVisible(errorMessage, driver);
			textError = errorMessage.getText();
			Assert.assertEquals(textError, "Invalid username or password.");
			log.info("Authentication failed : " + textError + "\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
