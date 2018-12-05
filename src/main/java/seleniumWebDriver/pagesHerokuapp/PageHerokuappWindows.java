package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

public class PageHerokuappWindows extends Page {

  @FindBy(xpath="//a[text()='Click Here']")
  private WebElement clickHere;

  //TODO Открыть страницу Windows сайта
  @Step("Открытие страницы Windows сайта")
  public void openWindows(){
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/windows");
  }

  //TODO Нажать ссылку "Click Here"
  @Step("Нажатие ссылки \"Click Here\"")
  public PageHerouappWindowsNew clickHere(){
    clickHere = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(clickHere));
    clickHere.click();
    return new PageHerouappWindowsNew();
  }
}
