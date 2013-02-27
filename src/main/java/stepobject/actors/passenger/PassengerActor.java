
package stepobject.actors.passenger;


import data.entity.Passenger;
import data.entity.Ticket;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import page.PassengerForm;
import stepobject.actors.AbstractActor;
import stepobject.step.AirportFeatureSteps;
import stepobject.step.BoardFeatureSteps;
import stepobject.step.TaxiFeatureSteps;
import utils.CheckUtils;
import utils.StepUtils;

/**
 * <b>Description:</b> This class represents Passenger end user
 * @author Tim Sukhachev
 */
public class PassengerActor extends AbstractActor {

  public PassengerActor(Pages pages) {
    super(pages);
  }

  public IPassengerAtTaxi atTaxi() {
    return at(TaxiFeatureSteps.class);
  }

  public IPassengerAtAirport atAirport() {
    return at(AirportFeatureSteps.class);
  }

  public IPassengerOnBoard onBoard() {
    return at(BoardFeatureSteps.class);
  }

  @StepGroup
   public void departs(Ticket ticket) {
    atTaxi().getsCar();
    atTaxi().paysForShuttle();
    atAirport().passesLuggageControl();
    atAirport().passesGateControl();
    onBoard().takesThePlace(ticket);
  }

  @StepGroup
  public void completesRegistrationForm(Passenger passenger, Ticket ticket) {
    PassengerForm passengerForm = getPages().get(PassengerForm.class);
    passengerForm.open();
    StepUtils.populate(PassengerForm.class, ticket);
    StepUtils.populate(PassengerForm.class, passenger);

    CheckUtils.fieldValueIs(Ticket.DEPARTURE_DATE, ticket.getDepartureTime(), passengerForm);

    passengerForm.clickSubmitButton();
  }
}
