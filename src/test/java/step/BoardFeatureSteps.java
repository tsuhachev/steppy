/**
 *
 */
package step;

import actors.passenger.IPassengerOnBoard;
import data.entity.Ticket;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class BoardFeatureSteps extends ScenarioSteps implements IPassengerOnBoard {
  public BoardFeatureSteps(Pages pages) {
    super(pages);
  }

  @Override @Step
  public void takesThePlace(Ticket ticket) {

  }

  @Override @Step
  public void enjoysTheFlight() {

  }
}
