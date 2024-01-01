package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains web element of Login page and their handler methods
 * @author Bhaskar
 *
 */
public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@id='Email']") private WebElement txtEmail;
	@FindBy(xpath="//input[@id='Password']") private WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']") private WebElement btnLogin;
	@FindBy(xpath="//a[text()='Logout']") private WebElement lnkLogout;
	
	/*
	 * This method is used to enter User Name in UserName text field.
	 */
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	/*
	 * This method is used to enter Password in Password text field.
	 */
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	/*
	 * This method is used to click Login button.
	 */
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	/*
	 * This method is used to click Logout link.
	 */
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
