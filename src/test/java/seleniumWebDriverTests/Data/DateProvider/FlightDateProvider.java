package seleniumWebDriverTests.Data.DateProvider;

import org.testng.annotations.DataProvider;
import seleniumWebDriverTests.Data.FlightData;

import java.time.LocalDate;

public class FlightDateProvider {
  @DataProvider(name = "flightDateSearch")
  public static Object[][] testDataFlight() {
    FlightData flightData = new FlightData();
    flightData.setAirportFrom("DME");
    flightData.setAirportTo("DXB");
    flightData.setFromData(LocalDate.now().plusDays(2));
    flightData.setGuests("2");
    return new Object[][]{{flightData}};
    }
  }
