package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;


public class pittTestUser1 {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for pitt.edu for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.pitt.edu");
	}

	/** User Story 1:
	 * As a perspective student,
	 * I would like to click on navigation links,
	 * So that I can learn about the University of Pittsburgh
	 */
	
	// Given that I am on the main page
	// When I look at the links
	// Then I see a link for perspective student
	
	@Test
	public void testHasPerspectiveLinks() {
		
		// Check for perspective student links - if any of
		// these is not found, fail the test
		
		try {
			driver.findElement(By.partialLinkText("Prospective"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I have clicked on the perspective student link
	// When I view the title on the new page
	// Then I see that it contains the word "perspective"
	
	@Test
	public void testPerspectiveStudentLinkWorks() {
		// Check if link is clickable and that the title says "perspective"
		// these is not found, fail the test

		try{
			driver.findElement(By.partialLinkText("Prospective")).click();
		}catch (NoSuchElementException nseex) {
			fail();
		}
		String title = driver.getTitle();
		assertTrue(title.contains("Prospective"));
	}
	
	// Given that I am on the main page
	// When I hover over "Admissions"
	// Then I see the apply link
	
	@Test
	public void testHasAdmissionsLinksWhenHovered() {

		// check hovered admissions link reveals apply link
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.partialLinkText("Admissions"));
		actions.moveToElement(menuHoverLink);
		
		assert (driver.findElement(By.partialLinkText("Apply"))!= null);
	}

	
	// Given that I have clicked on the the apply link
	// When I view the header on the new page
	// Then I see that it contains the word "apply"

	@Test
	public void testApplyLinkWorks() {
		// Check if "apply" link is clickable and that the url is correct
		// these is not found, fail the test
		
		Actions apllyLink = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.partialLinkText("Admissions"));
		apllyLink.moveToElement(menuHoverLink);
		driver.findElement(By.partialLinkText("Apply")).click();
		
		String url = driver.getCurrentUrl();
		assert(url.contentEquals("https://oafa.pitt.edu/apply/"));
	}

}
	

