package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
	
	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		co.addArguments("start-maximized");
		driver = new ChromeDriver(co);
		
		lp = new LoginPage(driver);
	    
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) {
	    driver.get(url);
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("^Click on Login$")
	public void click_on_Login() {
		lp.clickLogin();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    } else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("^User click on Logout link$")
	public void user_click_on_Logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("^Close browser$")
	public void close_browser() {
	    driver.quit();
	}
	
	//Customers feature step definitions -------------------------------------------------
	
	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() {
		acp = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}

	@When("^User click on Customers Menu$")
	public void user_click_on_Customers_Menu() throws InterruptedException {
	    Thread.sleep(2000);
		acp.clickOnCustomersMenu();
	}

	@When("^Click on Customers Menu Item$")
	public void click_on_Customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		acp.clickOnCustomersMenuItem();
	}

	@When("^Click on Add new button$")
	public void click_on_Add_new_button() throws InterruptedException {
	    Thread.sleep(5000);
		acp.clickOnAddNew();
		Thread.sleep(2000);
	}

	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() throws InterruptedException {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws InterruptedException {
	   String email = randomString()+"@gmail.com";
	   acp.setEmail(email);
	   acp.setPassword("test123");
	   
	   //Registered - default
	   //The customer cannot be in both 'Guests' and 'Registered' customer roles
	   //Add the customer to 'Guests' or 'Registered' customer role
	   
	   acp.setCustomersRoles("Registered");
	   Thread.sleep(5000);
	   acp.setManagerOfVendor("Vendor 2");
	   acp.setGender("Male");
	   acp.setFirstName("John");
	   acp.setLastName("Doe1");
	   acp.setDob("8/1/1966");
	   acp.setCompanyName("BusyQA");
	   acp.setAdminComment("This is for Testing....");
	   
	}

	@When("^Click on Save button$")
	public void click_on_Save_button() throws InterruptedException {
	    acp.clickOnSave();
	    Thread.sleep(2000);
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) {
	  Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
			  .contains("The new customer has been added successfully."));
	  
	}
	
	//Steps for searching a customer using Email Id------------------------------------------
	@When("^Enter Customer Email$")
	public void enter_Customer_Email() {
		scp = new SearchCustomerPage(driver);
		scp.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws InterruptedException {
		scp.clickSearch();
		Thread.sleep(3000);
	}

	@Then("^User should find Email in th Search table$")
	public void user_should_find_Email_in_th_Search_table() {
		boolean status = scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//Steps for searching a customer using FirstName and LastName
	@When("^Enter customer FirstName$")
	public void enter_customer_FirstName() {
		scp = new SearchCustomerPage(driver);
		scp.setFirstName("Victoria");
	}

	@When("^Enter customer LastName$")
	public void enter_customer_LastName() {
	    scp.setLastName("Terces");
	}

	@Then("^User should find Name in the Search table$")
	public void user_should_find_Name_in_the_Search_table() {
	   boolean status = scp.searchCustomerByName("Victoria Terces");
	   Assert.assertEquals(true, status);
	}

	

}
