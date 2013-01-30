/**
 *
 */
package page;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
@DefaultUrl(value = "http://www.google.com.ua")
public class MyPageObject extends BasePageObject {

  public static final By Q = By.name("q");
  public static final By BTN_G = By.name("btnG");

  public MyPageObject(WebDriver webDriver) {
    super(webDriver);
  }

  public void typeKeyword(String keyword) {
    getDriver().findElement(Q).sendKeys(keyword);
  }

  public void clickSearchButton() {
    getDriver().findElement(BTN_G).click();
  }

  public void clear() {
    getDriver().findElement(Q).clear();
  }
}
