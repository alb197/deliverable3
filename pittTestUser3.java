package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class pittTestUser3 {
static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for pitt.edu for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.pitt.edu");
	}
	
	/** User Story 3:
	 * As a professor looking to be hired by Pitt, 
	 * I would like to click on links 
	 * So that I could find out information regarding available positions to apply for.
	 */

	// Given that I am on the main page
	// When I click on search button
	// Then I am redirected to my results
	
	@Test
	public void testSearchFeature() {
		
		// find search, check if search works by sending a search time, see that results exist

		
		WebElement element = driver.findElement(By.name("search_block_form"));
	    element.sendKeys("Laboon");
	    element.sendKeys(Keys.RETURN);
	    assert (driver.findElement(By.name("Laboon"))!=null); //is it good enough?
	    
	}
		
		//Given that I am on the main page
		// When I look at the links on the buttom
		// Then I see a "contact" link
	
	@Test
	public void testHasContact() {
		
		// Check if webpage has "contact us"
		// these is not found, fail the test
		
		try {
			driver.findElement(By.xpath("//*[@id='nodesinblock-21']/article/section/p[1]/a"));
		} catch (NoSuchElementException nseex) {
			fail();	
		}	
	}
}	