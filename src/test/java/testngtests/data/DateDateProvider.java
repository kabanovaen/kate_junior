package testngtests.data;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDateProvider {
  private static LocalDate now = LocalDate.now();

  @DataProvider(name = "dpDate", parallel = true)
  public static Object[][] testDataDate() {
    return new Object[][]{{LocalDate.now()}, {LocalDate.now().minusDays(1)}, {LocalDate.now().minusDays(2)}, {LocalDate.now().minusDays(3)}};
  }

  @DataProvider(name = "dpDateN", parallel = true)
  public static Object[][] testDataDateN() {
    return new Object[][]{{LocalDate.now().plusDays(1)},{LocalDate.of(2018, 1, 1)}, {LocalDate.now().minusDays(4)}};
  }

  @DataProvider(name = "dpDateString", parallel = true)
  public static Object[][] testDataDateString() {
    return new Object[][]{{now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {now.minusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {now.minusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {now.minusDays(3).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {"32-10-2018"}}; //Для проверки Exception, что обрабатывается корректно неверно введенная дата
  }

  @DataProvider(name = "dpDateStringN", parallel = true)
  public static Object[][] testDataDateStringN() {
    return new Object[][]{{now.plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {now.minusDays(4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))},
            {"01-01-2018"},
            {"31-13-2018"}}; //Для проверки Exception, что обрабатывается корректно неверно введенная дата
  }
}