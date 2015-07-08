package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class pittTestUser2 {
static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for pitt.edu for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.pitt.edu");
	}
	
	
	/** User Story 2:
	 * As a current student,
	 * I would like to click on external links,
	 * So that I can find my classmates and login
	 */
	
	// Given that I have clicked on the "find people" link
	// When I view the title on the new page
	// Then I see that it contains the word "find people"
	
	@Test
	public void testFindPeopleLinkWorks() {
		// Check if link is clickable
		// these is not found, fail the test
		
		try{
			driver.findElement(By.partialLinkText("Find People")).click();
		}catch (NoSuchElementException nseex) {
			fail();
		}
		// Once clicked, check that the title states "Find people"
		String title = driver.getTitle();
		assertTrue(title.contains("Find People"));
	}
	
	//Given that I have clicked on the "my pitt" link
	//When I view the button the new page
	//Then I see that it contains the word "login" 
	
	@Test
	public void testMyPittLinkWorks() {
		// Check if link is clickable and that the title says "my.pitt.edu"
		// these is not found, fail the test
		
		try{
			driver.findElement(By.linkText("my.pitt.edu")).click();
		}catch (NoSuchElementException nseex) {
			fail();
		}
		// Once clicked, check that there is a login button
		assert (driver.findElement(By.xpath("//*[@id='input10576']"))!= null);
	}
		
}
