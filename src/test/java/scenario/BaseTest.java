package scenario;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import org.openqa.selenium.WebDriver;

/**
 * <b>Description:</b> This class represents base class for tests
 * @author Tim Sukhachev
 */
public class BaseTest {

  @Managed(uniqueSession = true)
  public WebDriver webdriver;

  @ManagedPages
  public Pages pages;
}
