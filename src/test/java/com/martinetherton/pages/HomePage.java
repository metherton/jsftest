package com.martinetherton.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	private final WebDriver driver;
	
	@FindBy(how = How.ID, using = "pageTitle")
	private WebElement pageTitle;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        if (!"Mijn SVB".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the home page");
        }		
	}

	public String pageTitle() {
		return pageTitle.getText();
	}
	
}
