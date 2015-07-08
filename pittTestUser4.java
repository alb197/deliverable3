package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class pittTestUser4 {
static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for pitt.edu for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.pitt.edu");
	}

	/** User Story 4:
	 * As a parent with a child in Pitt, 
	 * I would like to learn about what activities that they can do on campus
	 * So that I could keep my little schnookums happy!
	 */
	
	// Given that I am on the main page
	// When I look at the links
	// Then I see a "parents" link

	@Test
	public void testHasParentsLink() {
		// Check if webpage has "parents"
		// these is not found, fail the test
				
		try {
			driver.findElement(By.partialLinkText("Parents"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
		
	}
	
	
	//Given that I have clicked on the "parents" link
	//When I view the title the new page
	//Then I see that it contains the word "parents"
	
	@Test
	public void testParentsLinkWorks() {
		// Check if link is clickable and that the title says "parents"
		// these is not found, fail the test

		try{
			driver.findElement(By.partialLinkText("Parents")).click();
		}catch (NoSuchElementException nseex) {
			fail();
		}
		String title = driver.getTitle();
		assertTrue(title.contains("Parents"));
	}
}
		