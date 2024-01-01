package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

/**
 * This class contains web element of Search Customer page and their handler methods
 * @author Bhaskar
 *
 */
public class SearchCustomerPage {
	
public WebDriver ldriver;
WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']") private WebElement txtSearchEmail;
	@FindBy(xpath="//input[@id='SearchFirstName']") private WebElement txtSearchFirstName;
	@FindBy(xpath="//input[@id='SearchLastName']") private WebElement txtSearchLastName;
	@FindBy(xpath="//table[@id='customers-grid']") private WebElement table;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr") private List <WebElement> tableRows;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td") private List <WebElement>  tableColumns;
	@FindBy(xpath="//button[@id='search-customers']") private WebElement btnSearch;
	
	
	
	
	public void setEmail(String email) 
	{
		waithelper.waitForElement(txtSearchEmail, 30);
		txtSearchEmail.clear();
		txtSearchEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) 
	{
		waithelper.waitForElement(txtSearchFirstName, 30);
		txtSearchFirstName.clear();
		txtSearchFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		waithelper.waitForElement(txtSearchLastName, 30);
		txtSearchLastName.clear();
		txtSearchLastName.sendKeys(lname);
	}
	
	public void clickSearch() {
		btnSearch.click();
		waithelper.waitForElement(btnSearch, 30);
	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		
		for(int i = 1; i <= getNoOfRows(); i++)
		{
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag = false;
		
		for(int i = 1; i <= getNoOfRows(); i++)
		{
			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			
			String names[] = name.split(" "); //separating fname and lastname, from webpage
			String Names[] = Name.split(" "); //from user input data
			if(names[0].equals(Names[0]) && names[1].equals(Names[1]))
			{
				flag = true;
			}
		}
		return flag;
	}
	
}
