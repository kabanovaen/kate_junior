package seleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class Page {

  public static void setDriver(WebDriver driver) {
    Page.driver = driver;
  }

  protected static WebDriver driver = null;

  public Page() {
    PageFactory.initElements(getDriver(), this);
    getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      driver = new ChromeDriver();
    }
    return driver;
  }
}
