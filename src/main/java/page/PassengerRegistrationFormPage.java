
package page;

import data.entity.Passenger;
import data.entity.Ticket;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * <b>Description:</b> This class represents page object for passenger registration form
 *
 * @author Tim Sukhachev
 */
@DefaultUrl("https://docs.google.com/spreadsheet/viewform?formkey=dHNMdnB4dl95SmZJU09VRC1GSDUzbUE6MQ")
public class PassengerRegistrationFormPage extends BasePageObject {

  public static final By SUBMIT = By.name("submit");

  public PassengerRegistrationFormPage(WebDriver webDriver) {
    super(webDriver);
    mapping();
  }

  private void mapping() {
    elementsMap.put(Passenger.NAME, By.name("entry.0.single"));
    elementsMap.put(Ticket.DESTINATION, By.name("entry.1.single"));
    elementsMap.put(Ticket.DEPARTURE_DATE, By.name("entry.2.single"));
    elementsMap.put(Ticket.TICKET_CLASS, By.name("entry.4.group"));
  }

  public void clickSubmitButton() {
    element(SUBMIT).click();
  }


}
