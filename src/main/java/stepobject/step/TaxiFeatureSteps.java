package stepobject.step;

import stepobject.actors.passenger.IPassengerAtTaxi;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import page.GooglePageObject;

/**
 * <b>Description:</b> This class represents step object for Taxi feature
 *
 * @author Tim Sukhachev
 */
public class TaxiFeatureSteps extends ScenarioSteps implements IPassengerAtTaxi {

  public TaxiFeatureSteps(Pages pages) {
    super(pages);
  }

  @Override @Step
  public void getsCar() {
    pages().get(GooglePageObject.class).open();
    pages().get(GooglePageObject.class).typeKeyword("I know what I'm doing");
  }

  @Override @Step
  public void paysForShuttle() {
    pages().get(GooglePageObject.class).clickSearchButton();
  }
}
