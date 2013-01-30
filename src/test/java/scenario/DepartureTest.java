/**
 *
 */
package scenario;

import actors.passenger.PassengerActor;
import data.entity.Passenger;
import data.entity.Ticket;
import data.enums.City;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

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
  private PassengerActor passengerActor;

  @Test
  public void departByStep() {
    passengerActor.atTaxi().getsCar();
    passengerActor.atTaxi().paysForShuttle();

    passengerActor.atAirport().passesLuggageControl();
    passengerActor.atAirport().passesGateControl();

    passengerActor.onBoard().takesThePlace(getTicket());
    passengerActor.onBoard().enjoysTheFlight();
  }

  @Test
  public void departByGroupStep() {
    passengerActor.departs(getTicket());
  }

  @Test
  public void populatePassengerForm() {
    passengerActor.completesPassengersForm(getPassenger(), getTicket());
  }

  private Ticket getTicket() {
    Ticket ticket = new Ticket();
    ticket.setDepartureTime("3.03.2013");
    ticket.setTicketClass("Econom");
    ticket.setDestination(City.LONDON.toString());
    return ticket;
  }

  private Passenger getPassenger() {
    Passenger passengerData = new Passenger();
    passengerData.setName("John Doe");
    return passengerData;
  }

}
