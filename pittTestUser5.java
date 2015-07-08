package deliverable3;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;


public class pittTestUser5 {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for pitt.edu for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.pitt.edu");
	}
	
	
	/** User Story 5:
	 * As a current professor, 
	 * I would like to view the academic calendar
	 * So that I can plan my year
	 */

	//Given that I am on the main page
	// When I enter a text in the search box and click search
	// Then I am redirected to view my results

	//Given that I am on the main page
	// When I look sections
	// Then I see a "calendar" link
	
	@Test
	public void testAcademicCalenderLinkWorks() {
		// Check if "Calendar" is clickable
		// check is the url is correct		
		
		driver.findElement(By.xpath("//*[@id='nodesinblock-613']/article/section/div[3]/ul[2]/li[1]/a")).click();
		String url = driver.getCurrentUrl();
		assert(url.contentEquals("http://www.provost.pitt.edu/information-on/calendar.html"));
	}
	
	
	@Test
	public void testHasWorkingFacultyLink() {
		// Check if webpage has "Faculty"
		// these is not found, fail the test
				
		try {
			driver.findElement(By.partialLinkText("Faculty")).click();
		}catch (NoSuchElementException nseex) {
			fail();
		}
		// Once clicked, check that the title states "Faculty"
		String title = driver.getTitle();
		assert(title.contains("Faculty"));
		
	}
}	