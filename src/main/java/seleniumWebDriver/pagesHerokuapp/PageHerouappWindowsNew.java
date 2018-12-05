package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

import java.util.ArrayList;

public class PageHerouappWindowsNew extends Page {
  @FindBy(xpath = "//body/div/h3")
  private WebElement h3;

  //TODO Получить название вкладки
  @Step("Получение названия вкладки")
  public String textTitle(){
    String oldTab = driver.getWindowHandle();
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    newTab.remove(oldTab);
    driver.switchTo().window(newTab.get(0));
    return driver.getTitle();
  }

  //TODO Получить название ссылки
  @Step("Получение названия ссылки")
  public String textH3(){
    h3 = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(h3));
    return h3.getText();
  }
}
