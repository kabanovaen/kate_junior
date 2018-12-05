package ru.atcourse.core;
public class SolutionCore {

  private StringBuffer getFromStringBuffer(String one, String two, String three) {
    return new StringBuffer().append(one).append(" ").append(two).append(" ").append(three).append(".");
  }

  private StringBuilder getFromStringBuilder(String one, String two, String three) {
    return new StringBuilder().append(one).append(" ").append(two).append(" ").append(three).append(".");
  }

  public static void main(String[] args) {
    StringUse su = new StringUse("one", "two", "three");
    String one = su.getOne();
    String two = su.getTwo();
    String three = su.getThree();
    SolutionCore o = new SolutionCore();

    System.out.println(one + " " + two + " " + three + ".");
    System.out.printf("%s %s %s.", one, two, three); // %s - символьное значение параметров
    System.out.println();
    //Принципы форматирования в этом случае абсолютно такие же, как у описанного выше printf, но этот метод вместо вывода строки сохраняет ее как отформатированную строку.
    System.out.println(String.format("%s %s %s.", one, two, three));
    System.out.println(o.getFromStringBuffer(one, two, three));
    System.out.println(o.getFromStringBuilder(one, two, three));
  }
}