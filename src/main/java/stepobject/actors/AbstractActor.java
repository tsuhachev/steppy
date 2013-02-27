
package stepobject.actors;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.StepFactory;
import utils.StepUtils;

/**
 * <b>Description:</b> This class represents abstract actor parent to real actors
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public abstract class AbstractActor extends ScenarioSteps {

  public AbstractActor(Pages pages) {
    super(pages);
    StepUtils.setPages(pages);
  }

  protected <S extends ScenarioSteps> S at(Class<S> tClass) {
    return new StepFactory(getPages()).getStepLibraryFor(tClass);
  }
}
