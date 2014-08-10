package com.martinetherton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AowBasicInformationPage {

	private final WebDriver driver;
	
	@FindBy(how = How.ID, using = "pageTitle")
	private WebElement pageTitle;

	private By aowLinkLocator = By.id("aowLink");

	//private By firstNameLocator = By.xpath("//span[contains(@id,'firstName')]");	
	
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'firstName')]")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'surname')]")
	private WebElement surname;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateOfBirth;	
	
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'bsn')]")
	private WebElement bsn;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'partnerFirstName')]")	
	private WebElement partnerFirstName;	
	
	public AowBasicInformationPage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        if (!"Mijn SVB".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the AOW Details page");
        }		
	}

	public String pageTitle() {
		return pageTitle.getText();
	}

	public String firstName() {
		return firstName.getAttribute("value");
	}
	
	public String bsn() {
		return bsn.getText();
	}
	
	public String surname() {
		return surname.getText();
	}
	
	public String dateOfBirth() {
		return dateOfBirth.getText();
	}

	public String partnerFirstName() {
		return partnerFirstName.getAttribute("value");
	}	
	
}
