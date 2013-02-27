/**
 *
 */
package scenario;

import data.entity.Passenger;
import data.entity.Ticket;
import data.enums.City;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepobject.actors.passenger.PassengerActor;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
@RunWith(ThucydidesRunner.class)
public class DepartureTest extends BaseTest {

  @Steps
  private PassengerActor passenger;

  /**
   * test with local step usage
   */
  @Test
  public void departByStep() {
    passenger.atTaxi().getsCar();
    passenger.atTaxi().paysForShuttle();

    passenger.atAirport().passesLuggageControl();
    passenger.atAirport().passesGateControl();

    passenger.onBoard().takesThePlace(getTicket());
    passenger.onBoard().enjoysTheFlight();
  }

  /**
   * test with global step usage
   */
  @Test
  public void departByGroupStep() {
    passenger.departs(getTicket());
  }

  /**
   * test with generic steps usage
   */
  @Test
  public void populatePassengerForm() {
    passenger.completesRegistrationForm(getPassenger(), getTicket());
  }

  /* data */

  private Ticket getTicket() {
    Ticket ticket = new Ticket();
    ticket.setDepartureDate("3.03.2013");
    ticket.setTicketClass("Economy");
    ticket.setDestination(City.LONDON.toString());
    return ticket;
  }

  private Passenger getPassenger() {
    Passenger passengerData = new Passenger();
    passengerData.setName(RandomStringUtils.randomAlphabetic(7));
    return passengerData;
  }

}
