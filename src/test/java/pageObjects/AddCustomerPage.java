package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

/**
 * This class contains web element of Add Customer page and their handler methods
 * @author Bhaskar
 *
 */
public class AddCustomerPage {
	
public WebDriver ldriver;
WaitHelper waithelper;	

	public AddCustomerPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	//Locators
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(), 'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(), 'Customers')]");
	
	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	
	By txtCustomerRoles = By.xpath("//label[text()='Customer roles']/ancestor::div[@class='col-md-3']/following-sibling::div[@class='col-md-9']/descendant::div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpMgrOfVendor = By.xpath("//select[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave = By.xpath("//button[@name='save']");
	
	//Action Methods
	
	/**
	 * This method is used to click on customers menu
	 */
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	/**
	 * This method is used to click on customers from menu items
	 */
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	/**
	 * This method is used to click on add new button
	 */
	public void clickOnAddNew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	/**
	 * This method is used to enter email
	 */
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	/**
	 * This method is used to enter password
	 */
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	/**
	 * This method is used to set customer roles from loopup
	 */
	public void setCustomersRoles(String role) throws InterruptedException 
	{
		if(!role.equals("Vendors")) //If role is Vendor should not delete Registered
		{
			waithelper.waitForElement(ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']")), 30);
			ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']")).click();
		}
		
//		WebElement addLookupCustomerRoles = ldriver.findElement(txtCustomerRoles);
//		selectOptions(addLookupCustomerRoles, role);
//		addLookupCustomerRoles.sendKeys(Keys.TAB);
//		Cant use Select class elements are defined under div
		
		WebElement listitems;
		
		Thread.sleep(3000);
		if(role.equals("Administrators"))
		{
			listitems = ldriver.findElement(lstitemAdministrators);
		}
		else if(role.equals("Guests"))
		{
			listitems = ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Registered"))
		{
			listitems = ldriver.findElement(lstitemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitems = ldriver.findElement(lstitemVendors);
		}
		else if(role.equals("Forum Moderators"))
		{
			listitems = ldriver.findElement(lstitemForumModerators);
		}
		else
		{
			listitems = ldriver.findElement(lstitemGuests); //Default
		}
		
//		listitems.click();
//		Thread.sleep(3000);
// 		Using Javascript here as element is hidden and not interactable	
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitems);
	}
	
	/**
	 * This method is used to set manager of vendor from dropdown
	 */
	public void setManagerOfVendor(String value) {
		selectOptions(ldriver.findElement(drpMgrOfVendor), value);
	}
	
	/**
	 * This method is used to select gender
	 */
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click(); //Default
		}
	}
	
	/**
	 * This method is used to enter first name
	 */
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	/**
	 * This method is used to enter last name
	 */
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	/**
	 * This method is used to enter date of birth
	 */
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	/**
	 * This method is used to enter company name
	 */
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	/**
	 * This method is used to enter admin comment
	 */
	public void setAdminComment(String content)
	{
		ldriver.findElement(txtAdminComment).sendKeys(content);
	}
	
	/**
	 * This method is used to click on save
	 */
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
	

	/**
	 * This method is used to select options using WebElement address and text
	 * @param address
	 * @param text
	 */
	public void selectOptions(WebElement address, String text)
	{
		Select sel = new Select(address);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to return current page title
	 * @return string
	 */
	public String getPageTitle() 
	{
		return ldriver.getTitle();
	}
	
	
}
