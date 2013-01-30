package step;

import actors.passenger.IPassengerAtTaxi;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import page.MyPageObject;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class TaxiFeatureSteps extends ScenarioSteps implements IPassengerAtTaxi {

  public TaxiFeatureSteps(Pages pages) {
    super(pages);
  }

  @Override @Step
  public void getsCar() {
    pages().get(MyPageObject.class).open();
    pages().get(MyPageObject.class).typeKeyword("I know what I'm doing");
  }

  @Override @Step
  public void paysForShuttle() {
    pages().get(MyPageObject.class).clickSearchButton();
  }
}
