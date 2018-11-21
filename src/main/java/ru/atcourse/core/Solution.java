package ru.atcourse.core;

import java.rmi.UnexpectedException;

public class Solution {
  public static void main(String[] args) {
    // Задача 2 в JAVA CORE
    ErrorCatching ec = new ErrorCatching();
    try {
      ec.doError();
    } catch (InternalError e) {
//      final void addSuppressed(Throwable exception) - добавляет исключение в список подавляемых исключений (JDK 7)
//      Throwable fillInStackTrace() - возвращает объект класса Throwable, содержащий полную трассировку стека.
//      Throwable getCause() - возвращает исключение, лежащее под текущим исключение или null
//      String getLocalizedMessage() - возвращает локализованное описание исключения
//      String getMessage() - возвращает описание исключения
//      StackTraceElement[] getStackTrace() - возвращает массив, содержащий трассировку стека и состояний из элементов класса StackTraceElement
//      final Throwable[] getSuppressed() - получает подавленные исключения (JDK 7)
//      Throwable initCause(Throwable exception) - ассоциирует исключение с вызывающим исключением. Возвращает ссылку на исключение.
//      void printStackTrace() - отображает трассировку стека
//      void printStackTrace(PrintStream stream) - посылает трассировку стека в заданный поток
//      void printStackTrace(PrintWriter stream) - посылает трассировку стека в заданный поток
//      void setStackTrace(StackTraceElement elements[]) - устанавливает трассировку стека для элементов (для специализированных приложений)
//      String toString() - возвращает объект класса String, содержащий описание исключения.
      System.out.println("Gotcha! java.lang.InternalError: This is InternalError!");
    }
    try {
      ec.doException();
    } catch (UnexpectedException e) {
      System.out.println("Gotcha! java.rmi.UnexpectedException: This is UnexpectedException!");
    }
  }
}