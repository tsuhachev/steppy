package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePageObject;

import java.util.List;

/**
 * <b>Description:</b> This class represent element object for a simple html radio button
 * 
 * @author Tim Sukhachev
 * 
 */
public class RadioButton extends BasePageObject {
  private final By name;

  public RadioButton(WebDriver webDriver, String nameAttribute) {
    super(webDriver);
    name = By.name(nameAttribute);
  }

  public void chooseByValue(String value) {
    List<WebElement> els = getDriver().findElements(name);
    for (WebElement webElement : els) {
      if (value.equalsIgnoreCase(webElement.getAttribute("value"))) {
        webElement.click();
        break;
      }
    }
  }

  /**
   * @return webelement of first selected radio button
   */
  public WebElement getSelected() {
    List<WebElement> els = getDriver().findElements(name);
    for (WebElement webElement : els) {
      if (webElement.isSelected()) {
        return webElement;
      }
    }
    return null;
  }
}
