import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
  public static void main(String[] args) {
    // Строка для сканирования, чтобы найти шаблон
    String str = "<div>\n" + "<h2>What is Lorem Ipsum?</h2>\n" + "<p><strong>Lorem Ipsum</strong> is simply dummy text of the printing and typesetting industry.\n" + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer\n" + "took a galley of type and scrambled it to make a type specimen book.</p>\n" + "<p><strong>Initial date: </strong>01.01.2001</p>\n" + "<p><strong>Initial time: </strong>15:28:13</p>\n" + "<p>It has survived not only five centuries,\n" + "but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s\n" + "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software </p>\n" + "<p><strong>Target date: </strong>22.10.2018</p>\n" + "<p><strong>Target time: </strong>7:10:55</p>\n" + "<p>like Aldus PageMaker including versions of Lorem Ipsum.</p>\n" + "</div>";
    String patternDate = "Target date[a-zA-Z: <>/0-9.]*"; // Дата
    String patternTime = "Target time[a-zA-Z: <>/0-9]*"; // Время
    // Создание Pattern объекта
    Pattern r = Pattern.compile(patternDate);
    Pattern g = Pattern.compile(patternTime);
    // Создание matcher объекта
    Matcher m = r.matcher(str);
    Matcher mm = g.matcher(str);
    if (m.find()) {
      String targetDate = m.group().replaceAll("[^.|\\d]*", "");
      System.out.println(targetDate);
    }
    if (mm.find()) {
      String targetTime = mm.group().replaceAll("[^:|\\d]*", "").substring(1);
      System.out.println(targetTime);
    }
  }
}