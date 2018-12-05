package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesHerokuapp.PageHerokuappWindows;
import seleniumWebDriver.pagesHerokuapp.PageHerouappWindowsNew;

import java.util.Set;

import static seleniumWebDriver.Page.getDriver;

public class SeleniumWebDriverHerokuappWindowsTests extends BaseTest {

  @Test(description = "Проверка ссылки Click Here на странице Windows", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка ссылки Click Here на странице Windows")
  public void clickHereWindowsTest(){
    PageHerokuappWindows pageHerokuappWindows = new PageHerokuappWindows();
    pageHerokuappWindows.openWindows();
    PageHerouappWindowsNew pageHerouappWindowsNew = pageHerokuappWindows.clickHere();
    Set<String> windowHandles = getDriver().getWindowHandles();
    Assert.assertEquals(2, windowHandles.size());
    String str = "New Window";
    String strTitle = pageHerouappWindowsNew.textTitle();
    Assert.assertEquals(strTitle, str, "Заголовок открывшейся вкладки: " + "\"" + strTitle + "\"" + " не соответствует ожидаемому результату: " + "\"" + str + "\"");
    Assert.assertEquals(pageHerouappWindowsNew.textH3(), str, "Заголовок открывшейся вкладки: " + "\"" + strTitle + "\"" + " не соответствует ожидаемому результату: " + "\"" + str + "\"");
  }
}