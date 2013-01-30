
package helper;

import data.entity.BaseEntity;
import net.thucydides.core.annotations.Step;
import page.BasePageObject;

/**
 * <b>Description:</b> This class represents generic step object
 *
 * @author Tim Sukhachev
 */
public class StepHelper {

  /**
   * populates fields available within the pageObject with values set at entity
   *
   * @param pageObject
   * @param entity
   * @param <T>
   */
  @Step
  public static <T extends BasePageObject> void populate(T pageObject, BaseEntity entity) {
    for (String field : EntityHelper.getFields(entity.getClass())) {
      pageObject.setValue(field, EntityHelper.getValueOfField(field, entity));
    }
  }
}
