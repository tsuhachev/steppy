
package stepobject.step;

import stepobject.actors.passenger.IPassengerAtAirport;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import page.GooglePageObject;

/**
 * <b>Description:</b> This class represents step object available within Airport feature
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class AirportFeatureSteps extends ScenarioSteps implements IPassengerAtAirport {

  public AirportFeatureSteps(Pages pages) {
    super(pages);
  }

  @Override @Step
  public void passesLuggageControl() {
     pages().get(GooglePageObject.class).clear();
  }

  @Override @Step
  public void passesGateControl() {
    pages().get(GooglePageObject.class).typeKeyword("gate control");
  }
}
