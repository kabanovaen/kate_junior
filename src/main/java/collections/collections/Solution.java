package collections.collections;

import java.util.*;

//    Создать новый класс Person с полями: name, age, position.
class Person {
  private String name;
  private int age;
  private String position;

  Person(String name, int age, String position) {
    this.name = name;
    this.age = age;
    this.position = position;
  }

  String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  String getPosition() {
    return position;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}

public class Solution {
  public static void main(String[] args){
//    Создать объект типа List<Integer> из 5 элементов.
      List<Integer> list = new ArrayList<>();
      for (int i = 1; i <= 5; i++) {
        list.add(i);
      }
//    Вывести в консоль весь список.
      System.out.println("Лист: " + list);
//    Вывести в консоль 3 по счёту элемент листа.
      System.out.println("Третий элемент листа: " + list.get(2));
//    Удалить из списка последний элемент и вывести список в консоль.
      list.remove(list.size() - 1);
      System.out.println("Лист после удаления последнего элемента: " + list);
//    Удалить из списка первый элемент и вывести список в консоль.
      list.remove(0);
      System.out.println("Лист после удаления первого элемента: " + list);
//    Удалить из списка второй по счёту элемент и вывести список в консоль.
      list.remove(1);
      System.out.println("Лист после удаления второго элемента: " + list);
//    Создать объект типа List<Integer> из 5 элементов при помощи метода Arrays.asList(...);
      List<Integer> li = Arrays.asList(1, 2, 3, 4, 5);
//    Создать объект типа List из уже существующей коллекции.
      List lis = list;
//    Создать объект типа List<Integer> firstList из 2 элементов.
      List<Integer> firstList = new ArrayList<>();
      firstList.add(30);
      firstList.add(31);
//    Создать объект типа List<Integer> secondList из 3 элементов
//    Добавить в firstList список secondList.
      List<Integer> secondList = new ArrayList<>();
      secondList.add(40);
      secondList.add(41);
      secondList.add(42);
      firstList.addAll(secondList);
//
//    Создать карту из имён (Ваня, Петя, Ира) типа Map<String, String> names.
      Map<String, String> map = new HashMap<>();
      map.put("1", "Ваня");
      map.put("2", "Петя");
      map.put("3", "Ира");
//    Вывести карту в консоль.
      System.out.println("Карта=> " + map);
//    Вывести в консоль имя "Петя".
      System.out.println("Карта, вывод Пети=> " + map.get("2"));
//    Вывести в консоль только имена Ваня и Ира.
      System.out.println("Карта, вывод Вани и Иры=> " + map.get("1") + ", " + map.get("3"));
//    Удалить из карты Петю и вывести карту в консоль.
      map.remove("2");
      System.out.println("Вывод карты после удаления Пети=> " + map);
//    Вывести в консоль только ключи (key)
      System.out.println("Вывод только ключей карты=> " + map.keySet());
//    Вывести в консоль только значения(values)
      System.out.println("Вывод только значений карты=> " + map.values());
//
//    Создать карту типа Map<String, Person> persons из 3 элементов.
      Map<String, Person> persons = new HashMap<>();
      Person person1 = new Person("Екатерина", 12, "Тестер");
      Person person2 = new Person("Надежда", 13, "Аналитик");
      Person person3 = new Person("Любовь", 14, "Разработчик");

      persons.put("111", person1);
      persons.put("222", person2);
      persons.put("333", person3);

//    Вывести в консоль все имена из карты.
//    ??????? Сделать по-другому
//    for (int i = 1; i <= 3; i++) {
//      String j = String.valueOf(i);
//      System.out.println("Имя " + i + "го " + "человека => " + persons.get("111").name);
//    }

// Перебор значений
      for (Map.Entry<String, Person> entry : persons.entrySet()) {
        //    Вывести в консоль все имена из карты.
        System.out.println("Имя: " + entry.getValue().getName());
        //    Вывести в консоль имена и должности всех людей из карты в формате "Имя: Николай | Должность: Директор"
        System.out.println("Имя: " + entry.getValue().getName() + " | Должность: " + entry.getValue().getPosition());
      }

//  Использование Итератора
      Iterator<Map.Entry<String, Person>> itr = persons.entrySet().iterator();
      while(itr.hasNext()){
        Map.Entry<String, Person> entry = itr.next();
        //    Вывести в консоль все имена из карты.
        System.out.println("Имя " + entry.getKey() + " человека: " + entry.getValue().getName());
  //          Вывести в консоль имена и должности всех людей из карты в формате "Имя: Николай | Должность: Директор"
        System.out.println("Имя: " + entry.getValue().getName() + " | Должность: " + entry.getValue().getPosition());
      }

//    Вывести в консоль возраст одного представителя из карты.
//    System.out.println("Возраст " + "1го " + "человека => " + persons.get("111").age);
      //    Создать объект типа List<Integer> из 7 элементов (1,3,2,3,4,3,5).
//    1.
//    List<Integer> listt = new ArrayList<>();
//    listt = Arrays.asList(1, 3, 2, 3, 4, 3, 5);
//    2.
//    List<Integer> listt = Arrays.asList(1, 3, 2, 3, 4, 3, 5);
//    Создать из этого листа новый объект типа Set и вывести его в консоль
//   Set<Integer> set = new HashSet<>(listt);

//    Создать объект типа List<Integer> из 7 элементов (1,3,2,3,4,3,5).
//    Создать из этого листа новый объект типа Set и вывести его в консоль.
//    3.
      Set<Integer> set = new HashSet<>(Arrays.asList(1, 3, 2, 3, 4, 3, 5));
      System.out.println("Вывод нового объекта Set из Листа: " + set);

      List <String> strings = Arrays.asList("abc", "", "bc");
      long count = strings.stream().filter(string -> string.isEmpty()).count();
      System.out.println(count);
  }
}