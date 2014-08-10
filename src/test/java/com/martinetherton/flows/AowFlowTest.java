package com.martinetherton.flows;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.martinetherton.pages.AowBasicInformationPage;
import com.martinetherton.pages.AowEntryPage;
import com.martinetherton.pages.HomePage;

public class AowFlowTest {

	private AowEntryPage aowEntryPage;
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/jsfDemo/aowEntry.xhtml");
		aowEntryPage = PageFactory.initElements(driver, AowEntryPage.class);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void aowEntryPage() {
		assertThat(aowEntryPage.pageTitle(), Matchers.is("AOW Entry"));
	}	
	
	@Test
	public void aowBasicInformationPage() {
		AowBasicInformationPage aowBasicInformationPage = aowEntryPage.loadBasicInformationForUserWithBsn("1");
		assertThat(aowBasicInformationPage.pageTitle(), Matchers.is("AOW Basic Information"));
		assertThat(aowBasicInformationPage.firstName(), Matchers.is("Jack"));
	}
	
	@Test
	public void aowPartnerPage() {
		AowBasicInformationPage aowBasicInformationPage = aowEntryPage.loadPartnerInformationForUserWithBsn("1");
		assertThat(aowBasicInformationPage.pageTitle(), Matchers.is("AOW Basic Information"));
		assertThat(aowBasicInformationPage.partnerFirstName(), Matchers.is("Jill"));
	}	
		
	
}
