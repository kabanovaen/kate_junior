package ru.atcourse.core.statdyn;

class ClassWithStaticExample {
  static String message; //статическая переменная message
  static {message = "new message";}//   статический блок инициализации статической переменной
  private String author; //приватная переменная author

  ClassWithStaticExample(String author) { //конструктор для класса ClassWithStaticExample
    this.author = author;
  }

  private String getAuthor() {
    return author;
  }

  void setAuthor(String author) {
    this.author = author;
  }

  static void printMessage (){
    System.out.println(message);
  }

  class DynamicClassExample {

    DynamicClassExample() {
    }

    String changeMessage (String message){return message = "updated message";
    }

    void printMessageWithAuthor() {
      System.out.println(message + ". " + getAuthor());
    }
  }
  }