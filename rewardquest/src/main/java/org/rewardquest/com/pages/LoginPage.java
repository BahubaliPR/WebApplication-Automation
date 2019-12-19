package org.rewardquest.com.pages;

/*
 * Bahubali P R
 */
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver = null;


	@FindBy(how = How.XPATH, using = ".//input[@placeholder='Your Name']")
	private WebElement enterUserName;

	@FindBy(how = How.XPATH, using = ".//input[@placeholder='Password']")
	private WebElement enterPassword;

	@FindBy(how = How.XPATH, using = ".//button[@class='signIn']")
	private WebElement signIn;

	/*
	 * Initialize all the web elements to driver
	 */
	public LoginPage(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Clicks on DEMO SITES Clicks on Automation practice table Select column
	 * Select cell data from the table
	 */
	public void getDataFromTheTable() {
		try {

			enterUserName.sendKeys("admin");

			enterPassword.sendKeys("abc@123");

			signIn.click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
