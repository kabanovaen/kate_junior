package ru.atcourse.core;

public class StringUse {
  private String one;
  private String two;
  private String three;

  StringUse(String one, String two, String three) {
    this.one = one;
    this.two = two;
    this.three = three;
  }

  String getOne() {
    return one;
  }

  String getTwo() {
    return two;
  }

  String getThree() {
    return three;
  }

  public void setOne(String one) {
    this.one = one;
  }

  public void setTwo(String two) {
    this.two = two;
  }

  public void setThree(String three) {
    this.three = three;
  }
}
