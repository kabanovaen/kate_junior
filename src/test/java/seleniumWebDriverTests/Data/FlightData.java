package seleniumWebDriverTests.Data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class FlightData implements Serializable {
  private String airportFrom;
  private String airportTo;
  private LocalDate fromData;
  private String guests;

//  @JsonCreator
  public FlightData(String airportFrom, String airportTo, LocalDate fromData, String guests)
{
    this.airportFrom = airportFrom;
    this.airportTo = airportTo;
    this.fromData = fromData;
    this.guests = guests;
  }

  public FlightData(){
  }

  public String getAirportFrom() {
    return airportFrom;
  }

  public void setAirportFrom(String airportFrom) {
    this.airportFrom = airportFrom;
  }

  public String getAirportTo() {
    return airportTo;
  }

  public void setAirportTo(String airportTo) {
    this.airportTo = airportTo;
  }

  public LocalDate getFromDate() {
    return fromData;
  }

  public void setFromData(LocalDate fromData) {
    this.fromData = fromData;
  }

  public String getGuests() {
    return guests;
  }

  public void setGuests(String guests) {
    this.guests = guests;
  }
}
