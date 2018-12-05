package logging.src;

import org.apache.log4j.Logger;

//1. Написать простой класс с методами doSomething(), doSomethingElse(). Добавить к классу логгер и залогировать действия в методах.

class Kate {
  private static Logger logger = Logger.getLogger(Kate.class);
  private int k = 5;

  int doSomething() {
    this.k = k*2;
    logger.info("Метод возвращает умноженное на 2 k: " + k);
    return  k;
  }
  int doSomethingElse(){
    this.k = k*3;
    logger.info("Метод возвращает умноженное на 3 k: " + k);
    return  k;
  }
}
