package ru.atcourse.oop;

abstract class Animals {
  int weight = 10; //переменная, в которой хранится вес
  int height = 10; //переменная, в которой хранится рост

  void voice() {
    System.out.println("Zvuk Animal, u dochek pereopredelen");
  }

  void voice1() {
    System.out.println("Zvuk Animal, u dochek ne pereopredelen");
  }
}