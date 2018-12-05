package java;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution{
  public static void main(String[] args) {
//    Как вывести на экран 10 случайных чисел, используя forEach
    Random random = new Random();
    random.ints().limit(10).forEach(System.out::println);

//    Как можно вывести на экран уникальные квадраты чисел используя метод map?
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    System.out.println("Уникальные квадраты чисел:" + numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList()));

//    Как получить текущую дату с использованием time API из Java 8?
    LocalDate today = LocalDate.now();
    System.out.println("Сегодня: " + today);
//    Как добавить 1 неделю к текущей дате с использованием time API?
    System.out.println("+1 неделя: " + today.plusWeeks(1)); //+1 неделя
//    Как добавить 1 месяц к текущей дате с использованием time API?
    System.out.println("+1 месяц: " + today.plusMonths(1)); //+1 месяц
//    Как добавить 1 год к текущей дате с использованием time API?
    System.out.println("+1 год: " + today.plusYears(1)); //+1 год
//    Как добавить 10 лет к текущей дате с использованием time API?
    System.out.println("+10 лет: " + today.plus(1, ChronoUnit.DECADES)); //+10 лет

//    Как получить следующий вторник используя time API?
    System.out.println("Следующий вторник: " + today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
//    Как получить вторую субботу текущего месяца используя time API?
    LocalDate firstInYear = LocalDate.of(today.getYear(), today.getMonth(), 1);
    System.out.println("Вторая суббота текущего месяца: " + firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
//    Как получить текущею дату в миллисекундах используя time API?
    Date currentDate = new Date();
    Instant now = currentDate.toInstant();
//    Как получить текущею дату по местному времени в миллисекундах используя используя time API?
    ZoneId currentZone = ZoneId.systemDefault();
    System.out.println("Текущая дата по местному времени в миллисекундах:" + LocalDateTime.ofInstant(now, currentZone));
  }
}