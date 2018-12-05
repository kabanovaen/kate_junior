package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesHerokuapp.PageHerokuappJavascript_alerts;

public class SeleniumWebDriverHerokuappJavascript_alertsTests extends BaseTest {

  @Test(description = "Проверка результата после закрытия Alert, появляющегося по нажатию кнопки \"Click for JS Alert\"", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка результата после закрытия Alert, появляющегося по нажатию кнопки \"Click for JS Alert\"")
  public void jsAlertCloseCheckResultTest(){
    PageHerokuappJavascript_alerts pageHerokuappJavascript_alerts = new PageHerokuappJavascript_alerts();
    pageHerokuappJavascript_alerts.openJavascript_alerts();
    pageHerokuappJavascript_alerts.clickJsAlert();
    pageHerokuappJavascript_alerts.closeOkAlert();
    Assert.assertEquals(pageHerokuappJavascript_alerts.checkResult(), "You successfuly clicked an alert", "Результат неверный!!!");
  }

  @Test(description = "Проверка результата после закрытия Alert по кнопку Ок, появляющегося по нажатию кнопки \"Click for JS Confirm\"", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка результата после закрытия Alert по кнопку Ок, появляющегося по нажатию кнопки \"Click for JS Confirm\"")
  public void jsConfirmClickOkCheckResultTest(){
    PageHerokuappJavascript_alerts pageHerokuappJavascript_alerts = new PageHerokuappJavascript_alerts();
    pageHerokuappJavascript_alerts.openJavascript_alerts();
    pageHerokuappJavascript_alerts.clickJsConfirm();
    pageHerokuappJavascript_alerts.closeOkAlert();
    Assert.assertEquals(pageHerokuappJavascript_alerts.checkResult(), "You clicked: Ok", "Результат неверный!!!");
  }

  @Test(description = "Проверка результата после закрытия Alert по кнопку Cancel, появляющегося по нажатию кнопки \"Click for JS Confirm\"", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка результата после закрытия Alert по кнопку Cancel, появляющегося по нажатию кнопки \"Click for JS Confirm\"")
  public void jsConfirmClickCancelCheckResultTest(){
    PageHerokuappJavascript_alerts pageHerokuappJavascript_alerts = new PageHerokuappJavascript_alerts();
    pageHerokuappJavascript_alerts.openJavascript_alerts();
    pageHerokuappJavascript_alerts.clickJsConfirm();
    pageHerokuappJavascript_alerts.closeCancelAlert();
    Assert.assertEquals(pageHerokuappJavascript_alerts.checkResult(), "You clicked: Cancel", "Результат неверный!!!");
  }

  @Test(description = "Проверка результата после закрытия Alert по кнопку Cancel, появляющегося по нажатию кнопки \"Click for JS Confirm\"", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка результата после закрытия Alert по кнопку Cancel, появляющегося по нажатию кнопки \"Click for JS Confirm\"")
  public void jsPromptClickOkCheckResultTest(){
    String str = "Kate";
    PageHerokuappJavascript_alerts pageHerokuappJavascript_alerts = new PageHerokuappJavascript_alerts();
    pageHerokuappJavascript_alerts.openJavascript_alerts();
    pageHerokuappJavascript_alerts.clickJsPrompt();
    pageHerokuappJavascript_alerts.fillTextJsPrompt(str);
    pageHerokuappJavascript_alerts.closeOkAlert();
    Assert.assertEquals(pageHerokuappJavascript_alerts.checkResult(), "You entered: " + str, "Результат неверный!!!");
  }
}
