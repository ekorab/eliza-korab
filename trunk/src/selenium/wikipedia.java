package selenium;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;





public class wikipedia {
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}	
		
	@Test	
	public void  testtestclass() throws Exception {
		driver.get("http://www.wikipedia.org/");
		Assert.assertEquals("Wikipedia", driver.getTitle());
		Assert.assertEquals("English", driver.findElement(By.cssSelector("strong")).getText());
		driver.findElement(By.cssSelector("strong")).click();
		Assert.assertEquals("Wikipedia,  the free encyclopedia", driver.getTitle());
	}
		
	@After
	public void tearDown() throws Exception{
	driver.quit();

	}

}
