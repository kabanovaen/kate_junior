package seleniumWebDriverTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import seleniumWebDriver.pagesHerokuapp.PageHerokuappUpload;

public class SeleniumWebDriverHerokuappUploadTests extends BaseTest {

  @Test(description = "Проверка успешной загрузки файла", groups = {"SWDHerokuapp", "all"})
  @Title("Проверка успешной загрузки файла")
  public void loadFileSuccessTest(){
    PageHerokuappUpload pageHerokuappUpload = new PageHerokuappUpload();
    pageHerokuappUpload.openUpload();
    Assert.assertEquals(pageHerokuappUpload.loadFileSuccess(),"File Uploaded!", "Файл загружен не успешно!!!");
  }
}
