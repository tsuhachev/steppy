
package actors.passenger;


import actors.AbstractActor;
import data.entity.Passenger;
import data.entity.Ticket;
import utils.StepUtils;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import page.PassengerForm;
import step.AirportFeatureSteps;
import step.BoardFeatureSteps;
import step.TaxiFeatureSteps;

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
  public void completesPassengersForm(Passenger passenger, Ticket ticket ) {
    PassengerForm passengerForm = getPages().get(PassengerForm.class);
    passengerForm.open();
    StepUtils.populate(passengerForm, ticket);
    StepUtils.populate(passengerForm, passenger);
    passengerForm.clickSubmitButton();
  }
}
