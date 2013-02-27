
package utils;

import data.entity.BaseEntity;
import net.thucydides.core.annotations.Step;
import page.BasePageObject;

/**
 * <b>Description:</b> This class represents generic step object
 *
 * @author Tim Sukhachev
 */
public class StepUtils extends StepObjectUtils {

  /**
   * populates fields available within the pageObject with values set at entity
   * @param pageObject
   * @param entity
   * @param <P>
   * @param <E>
   */
  @Step
  public static <P extends BasePageObject, E extends BaseEntity> void populate(P pageObject, E entity) {
    for (String field : EntityUtils.getFields(entity.getClass())) {
      pageObject.setValue(field, EntityUtils.getValueOfField(field, entity));
    }
  }

  @Step
  public static <P extends BasePageObject, E extends BaseEntity> void populate(Class<P> pageClass, E entity) {
    P pageObject = getPages().get(pageClass);
    for (String field : EntityUtils.getFields(entity.getClass())) {
      pageObject.setValue(field, EntityUtils.getValueOfField(field, entity));
    }
  }
}
