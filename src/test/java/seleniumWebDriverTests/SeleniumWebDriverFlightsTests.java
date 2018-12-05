package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesFlights.Book;
import seleniumWebDriver.pagesFlights.HomePageFlights;
import seleniumWebDriver.pagesFlights.SearchResult;
import seleniumWebDriverTests.Data.DateProvider.FlightDateProvider;
import seleniumWebDriverTests.Data.FlightData;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SeleniumWebDriverFlightsTests extends BaseTest {

  @Test(description = "Проверка, что в полях проставились введенные значения", dataProvider = "flightDateSearch", dataProviderClass = FlightDateProvider.class, groups = {"SWDFlights", "all"})
  @Title("Проверка, что в полях проставились введенные значения")
  public void checkFullDataTest(FlightData flightDataT) {
    HomePageFlights homePageFlights = new HomePageFlights();
    homePageFlights.open();
    homePageFlights.clickFlights();
    homePageFlights.clickOneWay();
    homePageFlights.fillSearchFlights(flightDataT.getAirportFrom(), flightDataT.getAirportTo(), flightDataT.getFromDate());
    // Получение значений фильтра
    String vAF = homePageFlights.valueAirportFrom();
    String vAT = homePageFlights.valueAirportTo();
    String vFD = homePageFlights.valueFromDate();
    String vG = homePageFlights.valueGuests();

    //Проверка введенных значений на форме фильтра, с ожидаемыми данными
    Assert.assertTrue(vAF.contains(flightDataT.getAirportFrom()), "Аэропорт отправления не совпадает с тестовым значением: " + flightDataT.getAirportFrom() + ", значение в поле: " + vAF);
    Assert.assertTrue(vAT.contains(flightDataT.getAirportTo()), "Аэропорт прибывания не совпадает с тестовым значением: " + flightDataT.getAirportTo() + ", значение в поле: " + vAT);
    Assert.assertTrue(vFD.contains(flightDataT.getFromDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), "Дата отправления не совпадает с тестовым значением: " + flightDataT.getFromDate() + ", значение в поле: " + vFD);
    Assert.assertTrue(vG.equals(flightDataT.getGuests()), "Количество гостей не совпадает с тестовым значением: " + flightDataT.getGuests() + ", значение в поле: " + vG);
  }

  @Test(description = "Проверка, что в результах поиска дата соответствует введенной дате", dataProvider = "flightDateSearch", dataProviderClass = FlightDateProvider.class, groups = {"SWDFlights", "all"})
  @Title("Проверка, что в результах поиска дата соответствует введенной дате")
  public void checkFullDateInResiltTest(FlightData flightData) {
    HomePageFlights homePageFlights = new HomePageFlights();
    homePageFlights.open();
    homePageFlights.clickFlights();
    homePageFlights.clickOneWay();
    homePageFlights.fillSearchFlights(flightData.getAirportFrom(), flightData.getAirportTo(), flightData.getFromDate());
    SearchResult searchResult = homePageFlights.clickSearchButton();
    ArrayList<String> tickets = searchResult.getDepartureDataList();
    for(int i = 0; i < tickets.size(); i++){
      Assert.assertTrue(tickets.get(i).contains(flightData.getFromDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), "Дата отправления не совпадает с тестовым значением: \"\n" + "                + flightData.getFromDate()\n" + "                + \", значение в поле: \" + tickets.get(i)");
    }
  }

  @Test(description = "Проверка, что на форме книг установлен чекбокс NOTES", dataProvider = "flightDateSearch", dataProviderClass = FlightDateProvider.class, groups = {"SWDFlights", "all"})
  @Title("Проверка, что на форме книг установлен чекбокс NOTES")
  public void checkboxNotesClickTest(FlightData flightData) {
    HomePageFlights homePageFlights = new HomePageFlights();
    homePageFlights.open();
    homePageFlights.clickFlights();
    homePageFlights.clickOneWay();
    homePageFlights.fillSearchFlights(flightData.getAirportFrom(), flightData.getAirportTo(), flightData.getFromDate());
    SearchResult searchResult = homePageFlights.clickSearchButton();
    Book book = searchResult.clickBookNon();
    Assert.assertTrue(book.clickNotes(), "CheckBox NOTES не установлен!!!!");
  }
}
