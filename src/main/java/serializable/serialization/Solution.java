package serializable.serialization;

import java.io.*;

public class Solution {
  public static void main(String[] arg){
    User user = new User();
    user.lifeLevel = 55;
    user.staticField = 45;
    Sord sord = new Sord();
    sord.level = 5;
    user.sord = sord;
    try {

      FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(user);
      objectOutputStream.close();

      user.staticField = 35;

      FileInputStream fileInputStream = new FileInputStream("tempFile");
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      User newUser = (User) objectInputStream.readObject();
      objectInputStream.close();
      System.out.println(newUser.lifeLevel); //transient переменная
      System.out.println(newUser.staticField); //Сериализация не работает для статических полей, прочитается значение не из файла

      System.out.println(newUser.sord); //transient объектного поля
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
