package seleniumWebDriver.pagesHerokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

public class PageHerokuappJavascript_alerts extends Page {

  @FindBy(xpath = "//button[@onclick='jsAlert()']")
  private WebElement jsAlert;

  @FindBy(xpath = "//button[@onclick='jsConfirm()']")
  private WebElement jsConfirm;

  @FindBy(xpath = "//button[@onclick='jsPrompt()']")
  private WebElement jsPrompt;

  @FindBy(xpath = "//p[@id='result']")
  private WebElement result;

  //TODO Открыть страницу javascript_alerts
  @Step("Открытие страницы javascript_alerts")
  public void openJavascript_alerts(){
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
  }

  //TODO Нажать на кнопку "Click for JS Alert"
  @Step("Нажатие на кнопку \"Click for JS Alert\"")
  public void clickJsAlert(){
    jsAlert = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(jsAlert));
    jsAlert.click();
  }

  //TODO Нажать на кнопку "Click for JS Confirm"
  @Step("Нажатие на кнопку \"Click for JS Confirm\"")
  public void clickJsConfirm(){
    jsConfirm = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(jsConfirm));
    jsConfirm.click();
  }

  //TODO Нажать на кнопку "Click for JS Prompt"
  @Step("Нажатие на кнопку \"Click for JS Prompt\"")
  public void clickJsPrompt(){
    jsPrompt = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.elementToBeClickable(jsPrompt));
    jsPrompt.click();
  }

  //TODO Ввести текст после нажатия кнопки "Click for JS Prompt"
  @Step("Ввод текста после нажатия кнопки \"Click for JS Prompt\"")
  public void fillTextJsPrompt(String str){
    Alert alert = driver.switchTo().alert();
    alert.sendKeys(str);
  }

  //TODO Закрыть Alert по кнопке Ok
  @Step("Закрытие Alert")
  public void closeOkAlert(){
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  //TODO Закрыть Alert по кнопке Cancel
  @Step("Закрытие Alert")
  public void closeCancelAlert(){
    Alert alert = driver.switchTo().alert();
    alert.dismiss();
  }

  //TODO Проверить результат
  @Step("Проверка результата")
  public String checkResult(){
    return result.getText();
  }
}
