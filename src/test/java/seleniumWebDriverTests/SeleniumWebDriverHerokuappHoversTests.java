package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesHerokuapp.PageHerokuappHovers;

import java.util.ArrayList;

public class SeleniumWebDriverHerokuappHoversTests extends BaseTest {

  @Test(description = "Проверка данных каждого пользователя", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка данных каждого пользователя")
  public void hoversAllUsersTest() {
    PageHerokuappHovers pageHerokuappHovers = new PageHerokuappHovers();
    pageHerokuappHovers.openHovers();
    for (int i = 1; i <= 3; i++) {
      ArrayList hoverUsers = pageHerokuappHovers.focuseImage(i);
      Assert.assertEquals(hoverUsers.get(0), "name: user" + i, "У пользователя не верное имя!!!");
      Assert.assertEquals(hoverUsers.get(1), "https://the-internet.herokuapp.com/users/" + i, "У пользователя отсутсвует ссылка!!!");
      Assert.assertEquals(hoverUsers.get(2), "View profile", "У пользователя ссылка называется не \"View profile\"!!!");
    }
  }
}
