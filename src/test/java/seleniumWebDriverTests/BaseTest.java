package seleniumWebDriverTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static seleniumWebDriver.Page.getDriver;

public abstract class BaseTest {

  @BeforeSuite(alwaysRun = true)
  void setDriver() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ekaterina\\Documents\\kate_junior\\src\\main\\resources\\chromedriver.exe");
  }

  @AfterTest
  void tearDown() {
    getDriver().quit();
  }
}
