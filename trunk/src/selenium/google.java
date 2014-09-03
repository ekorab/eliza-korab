package selenium;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class google {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
    driver = new FirefoxDriver();
  }
// Search using keyword through Google search

  @Test
  public void testtestclass() throws Exception {
        //Open Home Page
        driver.get("http://www.google.com");
        //Enter text in search box
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(1000);
        //Click Search button
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(10000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    }
  }





