package com.martinetherton.flows;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.martinetherton.pages.AowEntryPage;
import com.martinetherton.pages.HomePage;

public class HomePageTest {

	private HomePage homePage;
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/jsfDemo");
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void homePage() {
		assertThat(homePage.pageTitle(), Matchers.is("Home"));
	}	
	
	@Test
	public void gotoAow() {
		AowEntryPage aowPage = homePage.gotoAow();
		assertThat(aowPage.pageTitle(), Matchers.is("AOW Entry"));
	}
}
