package seleniumWebDriver.pagesFlights;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePageFlights extends Page {

  //Элемент закладки "FLIGHTS"
  @FindBy (xpath = "//li[@data-title='flights']")
  private WebElement flights;

  //Элемент Ввода аэропорта отправления
  @FindBy (xpath = "//div[@id='s2id_location_from']")
  private WebElement locationFrom;

  //Элемент значенпия аэропорта отправления
  @FindBy (xpath = "//input[@id='location_from_code']")
  private WebElement locationFromValue;

  //Элемент Ввода аэропорта прибывания
  @FindBy (xpath = "//*[@id='s2id_location_to']")
  private WebElement locationTo;

  //Элемент значенпия аэропорта прибывания
  @FindBy (xpath = "//input[@id='location_to_code']")
  private WebElement locationToValue;

  //Элемент поиска аэропорта
  @FindBy (xpath = "//div[@id='select2-drop']/div[@class='select2-search']/input")
  private WebElement departPlace;

  //Элемент найденных аэропортов после ввода значения в поиске
  @FindBy (xpath = "//div[@class='select2-result-label']")
  private WebElement departPlaceList;

  //Элемент Ввода даты отправления
  @FindBy (xpath = "//input[@name='departure']")
  private WebElement FromDate;

  //Элемент выбора количества гостей
  @FindBy (xpath = "//div[@class=\"col-md-1 form-group go-right col-xs-12\"]")
  private WebElement guests;

  //Элемент выбора количества гостей
  @FindBy (xpath = "//input[@name='totalManualPassenger']")
  private WebElement guestsValue;

  //Элемент количества гостей Adults старше 12 лет
  @FindBy (xpath = "//*[@id=\"manual_flightTravelers\"]//select[@name='madult']")
  private WebElement adults;

  //Элемент выпадающего списка количества гостей Adults старше 12 лет равное 2
  @FindBy (xpath = "//*[@id=\"manual_flightTravelers\"]//select[@name='madult']/option[@value='2']")
  private WebElement adults2;

  //Элемент кнопки DONE на форме Guests
  @FindBy (xpath = "//button[@id='sumManualPassenger']")
  private WebElement doneButton;

  //Элемент кнопки SEARCH на закладке FLIGHTS
  @FindBy (xpath = "//div[@id='flights']//button[@type='submit']")
  private WebElement searchButton;

  //Элемент скрытия/доступности формы Guests
  @FindBy (xpath = "//div[@id='manual_flightTravelers']")
  private Boolean manual_flightTravelers;

  //Элемент "One Way" в один конец
  @FindBy (xpath = "//div[@class='iradio_square-grey checked']")
  private WebElement oneWay;

  //TODO Открыть страницу сайта
  @Step("Открытие страницы сайта")
  public void open(){
    driver.manage().window().maximize();
    driver.get("https://www.phptravels.net/");
  }

  //TODO Выбрать закладку "FLIGHTS" на главной странице
  @Step("Выбор закладки \"FLIGHTS\"")
  public void clickFlights() {
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(flights)).click();
  }

  //TODO На закладке "FLIGHTS" главной страницы ввести аэропорт отправления
  @Step("Ввод аэропорта отправления на закладке FLIGHTS")
  private void fillAirportFrom(String airportFrom) {
    locationFrom = (new WebDriverWait(driver, 20))
              .until(ExpectedConditions.elementToBeClickable(locationFrom));
    locationFrom.click();
    departPlace.sendKeys(airportFrom);//"DME"
    departPlaceList = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(departPlaceList));
    departPlace.sendKeys(Keys.ENTER);
  }

  //TODO На закладке "FLIGHTS" главной страницы ввести аэропорт прибывания
  @Step("Ввод аэропорта прибывания на закладке FLIGHTS")
  private void fillAirportTo(String airportTo) {
    locationTo = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(locationTo));
    locationTo.click();
    departPlace.sendKeys(airportTo);//"DXB");
    departPlaceList = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(departPlaceList));
    departPlace.sendKeys(Keys.ENTER);
  }

  //TODO На закладке "FLIGHTS" главной страницы ввести дату отправления +2 дня от текущей даты
  @Step("Ввод даты отправления на закладке FLIGHTS")
  private void fillFromDate(LocalDate localDate) {
    FromDate = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(FromDate));
    FromDate.click();
    FromDate.sendKeys(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
  }

  //TODO На закладке "FLIGHTS" главной страницы ввести количество гостей
  @Step("Ввод количества гостей на закладке FLIGHTS")
  private void fillGuests() {
    guests = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(guests));
    guests.click();
    adults = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(adults));
    adults.click();
    adults2 = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(adults2));
    adults2.click();
    doneButton = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(doneButton));
    doneButton.click();
    manual_flightTravelers = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='manual_flightTravelers']")));
  }

  //TODO На закладке "FLIGHTS" главной страницы кликнуть кнопку SEARCH
  @Step("Ввод даты отправления на закладке FLIGHTS")
  public SearchResult clickSearchButton() {
    searchButton = (new WebDriverWait(driver, 20))
    .until(ExpectedConditions.elementToBeClickable(searchButton));
    searchButton.click();
    return new SearchResult();
  }

  //TODO На закладке "FLIGHTS" главной страницы кликнуть чекбокс "One Way"
  @Step("Ввод даты отправления на закладке FLIGHTS")
  public void clickOneWay() {
    oneWay = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(oneWay));
    oneWay.click();
  }

  //TODO На закладке "FLIGHTS" главной страницы получить аэропорт отправления
  @Step("Получение значения аэропорта отправления на закладке FLIGHTS")
  public String valueAirportFrom() {
    return locationFromValue.getAttribute("value");
  }

  //TODO На закладке "FLIGHTS" главной страницы получить аэропорт прибывания
  @Step("Получение значения аэропорта прибывания на закладке FLIGHTS")
  public String valueAirportTo() {
    return locationToValue.getAttribute("value");
  }

  //TODO На закладке "FLIGHTS" главной страницы получить дату отправления
  @Step("Получение значения даты отправления на закладке FLIGHTS")
  public String valueFromDate() {
    return FromDate.getAttribute("value");
  }

  //TODO На закладке "FLIGHTS" главной страницы получить количество гостей
  @Step("Получение значения количества гостей на закладке FLIGHTS")
  public String valueGuests() {
    return guestsValue.getAttribute("value");
  }

  @Step("Заполнение полей (эропорты отправления и пребывания, даты отправления) для поиска")
  public void fillSearchFlights(String flightDataAirportFrom, String flightAirportTo, LocalDate flightFromDate){
    fillAirportFrom(flightDataAirportFrom);
    fillAirportTo(flightAirportTo);
    fillFromDate(flightFromDate);
    fillGuests();
  }

  //TODO Закрытие браузера
  @Step("Закрытие браузера")
  public void quit(){
    getDriver().quit();
  }
}
