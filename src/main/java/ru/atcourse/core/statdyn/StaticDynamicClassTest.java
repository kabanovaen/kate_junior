package ru.atcourse.core.statdyn;

import static ru.atcourse.core.statdyn.ClassWithStaticExample.message;

public class StaticDynamicClassTest{

  public static void main(String[] args) {
    ClassWithStaticExample staticExample = new ClassWithStaticExample("new Author");
    ClassWithStaticExample.DynamicClassExample dynObject = staticExample.new DynamicClassExample();//Объявление объекта внутреннего класса ClassWithStaticExample.DynamicClassExample
    staticExample.printMessage();
    dynObject.printMessageWithAuthor();
    message = dynObject.changeMessage(message);
    staticExample.printMessage();
    dynObject.printMessageWithAuthor();
    staticExample.setAuthor("updated Author");
    dynObject.printMessageWithAuthor();
  }
}