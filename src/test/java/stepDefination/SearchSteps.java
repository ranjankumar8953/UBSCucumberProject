package stepDefination;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.usbdemocucumber.baseclass.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchSteps extends TestBase {
	@Before
	public void setUp() {
		initializeDriver("chrome");
	}

	@Given("I am on Cucumber Home Page")
	public void i_am_on_cucumber_home_page() {
		driver.findElement(By.xpath("//a[@class='nav--menu_item_anchor' and @id='menu-item-40489']")).click();
	}

	@When("I search for Cucumber page then Cucumber Hooks open")
	public void i_search_for_cucumber_page_then_cucumber_hooks_open() {
		driver.findElement(By.xpath("//input[@class='form-control' and @id='search']")).sendKeys("Cucumber");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-search' and @type='submit']")).click();
	}

	@Then("I can get seven chapter on Cucumber Hooks page")
	public void i_can_get_seven_chapter_on_cucumber_hooks_page() throws InterruptedException {
		List<WebElement> cucumberLink = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = cucumberLink.iterator();

		WebElement cucumberText;
		while (itr.hasNext()) {
			cucumberText = itr.next();
			if (cucumberText.getText().equalsIgnoreCase("Cucumber Hooks")) {
				cucumberText.click();
				break;
			}
		}
		Thread.sleep(10000);
		List<WebElement> header = driver.findElements(By.tagName("h2"));
		int size = header.size();
		System.out.println(size);
		Assert.assertEquals(7, size);

	}

	@After
	public void cleanUp() {
		driver.close();
	}
}
