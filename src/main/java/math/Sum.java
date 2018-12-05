package math;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sum {

  public static int sum(int a, int b) {
    return a+b;
  }

  public static void main(String[] args) {
    System.out.println(LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
  }
}
