package com.martinetherton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AowEntryPage {

	private final WebDriver driver;

	@FindBy(how = How.ID, using = "pageTitle")
	private WebElement pageTitle;

	private By bsnLocator = By.xpath("//input[contains(@id,'bsn')]");
	private By submitLocator = By.xpath("//input[contains(@id,'submit')]");

	private By partnerTabLocator = By.xpath("//a[text()='Partner Details']");	
	
	public AowEntryPage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        if (!"Mijn SVB".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the AOW Entry page");
        }		
	}

	public String pageTitle() {
		return pageTitle.getText();
	}

	public AowBasicInformationPage loadBasicInformationForUserWithBsn(String bsn) {
		driver.findElement(bsnLocator).clear();
		driver.findElement(bsnLocator).sendKeys(bsn);
		driver.findElement(submitLocator ).click();
		return PageFactory.initElements(driver, AowBasicInformationPage.class);
	}

	public AowBasicInformationPage loadPartnerInformationForUserWithBsn(
			String bsn) {
		driver.findElement(partnerTabLocator).click();
		driver.findElement(bsnLocator).clear();
		driver.findElement(bsnLocator).sendKeys(bsn);
		driver.findElement(submitLocator ).click();
		AowBasicInformationPage aowBasicInformationPage = PageFactory.initElements(driver, AowBasicInformationPage.class);
		driver.findElement(partnerTabLocator).click();
		return aowBasicInformationPage;
	}	
	
}
