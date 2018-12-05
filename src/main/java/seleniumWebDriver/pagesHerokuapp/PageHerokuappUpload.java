package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

public class PageHerokuappUpload extends Page {

  @FindBy(xpath = "//input[@id='file-upload']")
  private WebElement selectFile;

  @FindBy(xpath = "//input[@id='file-submit']")
  private WebElement upload;

  @FindBy(xpath = "//div[@id='content']//h3")
  private WebElement uploadResult;

  //TODO Открыть страницу Upload сайта
  @Step("Открытие страницы Upload сайта")
  public void openUpload(){
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/upload");
  }

  //TODO Загрузить файл
  @Step("Загрузка файла")
  public String loadFileSuccess(){
    selectFile = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(selectFile));
    selectFile.sendKeys("C:\\Users\\Ekaterina\\Documents\\kate_junior\\src\\main\\resources\\1536318486813.jpg");
    upload = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(upload));
    upload.click();
    uploadResult = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(uploadResult));
    return uploadResult.getText();
  }
}
