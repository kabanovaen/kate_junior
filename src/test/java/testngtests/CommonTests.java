package testngtests;

import org.testng.Assert;
import testngtests.data.DateDateProvider;
import testngtests.data.SumDataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static math.Sum.sum;
import static org.testng.Assert.*;

public class CommonTests {
  @Test(dataProvider = "dp", dataProviderClass = SumDataProvider.class, groups = {"sum", "all"}, dependsOnGroups = "date", enabled = false)
  public void sumTest(int a, int b, int s) {
    int res = sum(a, b);
    assertEquals(res, s, "Сумма рассчитана неверно!!!");
  }

  @Test(dataProvider = "dpn", dataProviderClass = SumDataProvider.class, groups = {"sum", "all"}, dependsOnGroups = "date", enabled = false)
//, expectedExceptions = NumberFormatException.class)
  public void sumTestNegative(String a, String b, int s) {
    try {
      sum(Integer.valueOf(a), Integer.valueOf(b));
    } catch (Exception ex) {
      if (!ex.getClass().getName().equals("java.lang.NumberFormatException")) Assert.fail("Не успех. Возник неожидаемый Exception! Ожидается NumberFormatException");
    }
  }

  /**
   * Аналог теста sumTestNegative, но с
   * expectedExceptions = NumberFormatException.class и без try
   */
  @Test(dataProvider = "dpn", dataProviderClass = SumDataProvider.class, expectedExceptions = NumberFormatException.class, groups = {"sum", "all"}, dependsOnGroups = "date", enabled = false)
  public void sumTestNegative1(String a, String b, int s) {
    sum(Integer.valueOf(a), Integer.valueOf(b));
  }

  @Test(dataProvider = "dpDate", dataProviderClass = DateDateProvider.class, groups = {"date", "all"})
  public void wdateTest(LocalDate ld) {
    try {
      if (ld.isBefore(LocalDate.now().minusDays(3)) && ld.isAfter(LocalDate.now())) {
        fail();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test(dataProvider = "dpDateN", dataProviderClass = DateDateProvider.class, groups = {"date", "all"})
  public void wdateTestNegative(LocalDate ld) {
    if (ld.isAfter(LocalDate.now().minusDays(3)) && ld.isBefore(LocalDate.now())) {
      fail();
    }
  }

  @Test(dataProvider = "dpDateString", dataProviderClass = DateDateProvider.class, groups = {"date", "all"})
  public void wdateTestString(String dateS) {
    try {
      LocalDate ld = LocalDate.parse(dateS, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      if (ld.isBefore(LocalDate.now().minusDays(3)) && ld.isAfter(LocalDate.now())) {
        fail();
      }
    } catch (Exception e) {
      fail("Неверный формат даты!!!");
    }
  }

  @Test(dataProvider = "dpDateStringN", dataProviderClass = DateDateProvider.class, groups = {"date", "all"})
  public void wdateTestStringNegative(String dateS) {
    try {
      LocalDate ld = LocalDate.parse(dateS, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      if (ld.isAfter(LocalDate.now().minusDays(3)) && ld.isBefore(LocalDate.now())) {
        fail();
      }
    } catch (Exception e) {
      fail("Неверный формат даты!!!");
    }
  }
}