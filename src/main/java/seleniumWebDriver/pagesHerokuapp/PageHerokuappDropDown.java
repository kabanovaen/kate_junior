package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

import java.util.List;

public class PageHerokuappDropDown extends Page {

  @FindBy(xpath = "//select[@id='dropdown']")
  private WebElement dropdown;

  @FindBy(xpath = "//select[@id='dropdown']/option")
  private List<WebElement> dropdownOptions;

  //TODO Открыть страницу Upload сайта
  @Step("Открытие страницы DropDown сайта")
  public void openDropDown(){
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/dropdown");
  }

  //TODO Выбрать из дропдауна значения Option2
  @Step("Выбор из дропдауна значения Option2")
  public String clickOption2(){
    dropdown = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(dropdown));
    dropdown.click();
    dropdownOptions = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOfAllElements(dropdownOptions));
    WebElement dropdownOption2 = dropdownOptions.get(2);
    return dropdownOption2.getText();
  }
}
