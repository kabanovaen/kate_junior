package seleniumWebDriver.pagesFlights;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResult extends Page {
  //  Элемент найденных билетов, в соответствии с поиском
  @FindBy(xpath = "//table[@id='load_data']//tr")
  private List<WebElement> loadData;

  @FindBy(xpath = "//table[@id='load_data']//tr//div[@class='col-md-4 col-sm-3 col-xs-4']//small")
  private List<WebElement> loadDataFromDate;

  @FindBy(xpath = "//button[@id='bookbtn']")
  private WebElement bookbtn;

  @Step("Найденные билеты") //Написать ожидание загрузки элементов при скроллинге
  public ArrayList<String> getDepartureDataList() {
    loadData = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(loadData));
    ArrayList<String> tickets = new ArrayList<>(loadDataFromDate.stream().map(el -> {
      scrollToElement(el);
      return el.getText();
    }).collect(Collectors.toList()));
    return tickets;
  }

  @Step("Скроллирование до билета")
  private void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  @Step("Нажатие на первом BOOK NON")
  public Book clickBookNon() {
    bookbtn = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(bookbtn));
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", bookbtn);
    return new Book();
  }

  //TODO Закрытие браузера
  @Step("Закрытие браузера")
  public void quit() {
    getDriver().quit();
  }
}
