package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

import java.util.ArrayList;
import java.util.List;

public class PageHerokuappHovers extends Page {

  @FindBy(xpath="//div[@class='figure']")
  private List<WebElement> hoverFigure;

  //TODO Открыть страницу Hovers сайта
  @Step("Открытие страницы Hovers сайта")
  public void openHovers(){
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/hovers");
  }

  //TODO Навести фокус на картинку
  @Step("Наведение фокуса на картинку пользователя {0}")
  public ArrayList focuseImage(int user){
    hoverFigure = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOfAllElements(hoverFigure));
    Actions action = new Actions(driver);
    action.moveToElement(hoverFigure.get(user-1));
    action.perform();
    ArrayList<String> hoverUsersCheck = new ArrayList<>();
    String pathH5 = "(//div[@class='figcaption']/h5)" + "[" + user + "]";
    String pathHref = "(//div[@class='figcaption']/a)" + "[" + user + "]";
    WebElement hoversH5 = hoverFigure.get(user-1).findElement(By.xpath(pathH5));
    WebElement hoversHref = hoverFigure.get(user-1).findElement(By.xpath(pathHref));
    hoverUsersCheck.add(hoversH5.getAttribute("innerText"));
    hoverUsersCheck.add(hoversHref.getAttribute("href"));
    hoverUsersCheck.add(hoversHref.getAttribute("innerText"));
    return hoverUsersCheck;
  }
}
