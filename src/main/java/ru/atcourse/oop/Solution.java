package ru.atcourse.oop;

public class Solution {
  public static void main(String[] args) {
    Cat murzik = new Cat();
    Dog muhtar = new Dog();
    Animals ani = new Cat();

    // Инкапсуляция - Определение параметров объекта через обращение к нему
    murzik.weight = 12;
    murzik.height = 50;
    muhtar.weight = 60;
    muhtar.height = 80;

    // Полиморфизм
    Solution solution = new Solution();
    solution.makeSound(muhtar);
    solution.makeSound(murzik);
    solution.makeSound(ani);
    ani.voice1();
  }

  private void makeSound(Animals animals) {
    animals.voice();
  }

  public void makeSound1(Animals animals) {
    animals.voice1();
  }
}
