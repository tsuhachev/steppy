/**
 *
 */
package actors;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.StepFactory;
import scenario.BaseTest;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public abstract class AbstractActor extends ScenarioSteps {

  public AbstractActor(Pages pages) {
    super(pages);
  }

  protected <T> T at(Class<? extends ScenarioSteps> tClass) {
    return (T) new StepFactory(BaseTest.pages).getStepLibraryFor(tClass);
  }
}
