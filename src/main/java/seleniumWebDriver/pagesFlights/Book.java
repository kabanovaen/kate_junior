package seleniumWebDriver.pagesFlights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import seleniumWebDriver.Page;

public class Book extends Page {
  @FindBy (xpath = "//div[@id='Guest']//div[@class='control__indicator']")
  private WebElement notes;

  @FindBy (xpath = "//div[@id='Guest']//label[@class='control control--checkbox ellipsis fs14']")
  private WebElement notesCheckBox;

  @Step("Нажатие на NOTES")
  public Boolean clickNotes(){
    notes = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(notes));
    Actions actions = new Actions(driver);
    actions.click(notes).perform();
    notesCheckBox = (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(notesCheckBox));
    if (notesCheckBox.getAttribute("aria-expanded").equals("true")) {
      return true;
    }
    else {return false;}
  }
}
