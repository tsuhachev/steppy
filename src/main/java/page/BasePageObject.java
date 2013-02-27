
package page;

import elements.ControlElement;
import elements.RadioButton;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.HTML;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Description:</b> This class re
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class BasePageObject extends PageObject {

  public BasePageObject(WebDriver webDriver) {
    super(webDriver);
  }

  protected Map<String, By> elementsMap = new HashMap<String, By>();

  public void setValue(String field, String value) {
    if (value == null) {
      return;
    }
    WebElement element = getDriver().findElement(getElementLocator(field));
    ControlElement controlElement = new ControlElement(element);
    WebElementFacade webElementFacade = new WebElementFacade(getDriver(), element, 200);
    switch (controlElement.getType()) {
      case BUTTON:
      case DIV:
      case LINK:
        webElementFacade.click();
        break;
      case CHECKBOX:
        Checkbox checkbox = new Checkbox(element);
        checkbox.setChecked("true".equalsIgnoreCase(value));
        break;
      case SELECT:
        new Select(element).selectByVisibleText(value);
        break;
      case RADIO:
        new RadioButton(getDriver(), element.getAttribute(HTML.Attribute.NAME.toString())).chooseByValue(value);
        break;
      case TEXT:
      case TEXT_AREA:
        webElementFacade.type(value);
        break;
      default:
        throw new IllegalStateException("Unknown element type");
    }
  }

  public String getValue(String field) {
    final WebElement element = getDriver().findElement(getElementLocator(field));
    final ControlElement controlElement = new ControlElement(element);
    switch (controlElement.getType()) {
      case TEXT:
        return element.getAttribute(HTML.Attribute.VALUE.toString());
      case DIV:
      case TEXT_AREA:
      case BUTTON:
      case LINK:
        return element.getText();
      case CHECKBOX:
        Checkbox checkbox = new Checkbox(element);
        return checkbox.isChecked() ? "true" : "false";
      case SELECT:
        new Select(element).getFirstSelectedOption();
      case RADIO:
        new RadioButton(getDriver(), element.getAttribute(HTML.Attribute.NAME.toString())).getSelected();
      default:
        throw new StaleElementReferenceException("Unknown element type");
    }
  }

  private By getElementLocator(String field) {
     if (elementsMap.containsKey(field)) {
       return elementsMap.get(field);
     }
     throw new IllegalStateException("No locator available at element map by key: " + field);
  }

  @Override
  public String toString() {
     return this.getClass().getSimpleName();
  }
}
