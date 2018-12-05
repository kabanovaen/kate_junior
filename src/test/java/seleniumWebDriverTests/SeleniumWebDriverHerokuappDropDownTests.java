package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesHerokuapp.PageHerokuappDropDown;

public class SeleniumWebDriverHerokuappDropDownTests extends BaseTest {


  @Test(description = "Проверка выбора Option 2 выпадающего списка", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка выбора Option 2 выпадающего списка")
  public void dropDownClickOption2Test(){
    PageHerokuappDropDown pageHerokuappDropDown = new PageHerokuappDropDown();
    pageHerokuappDropDown.openDropDown();
    String str = pageHerokuappDropDown.clickOption2();
    Assert.assertEquals(str,"Option 2", "Выбран неверный dropDown!!!");
  }
}
