
package utils;

import data.entity.BaseEntity;
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
   * @param entities
   * @param <P>
   * @param <E>
   */
  public static <P extends BasePageObject, E extends BaseEntity> void populate(P pageObject, E... entities) {
    for (int i = 0; i < entities.length; i++) {
      for (String field : EntityUtils.getFields(entities[i].getClass())) {
        pageObject.setValue(field, EntityUtils.getValueOfField(field, entities[i]));
      }
    }
  }

  /**
   * populates fields available within the pageObject with values set at entity
   * @param pageClass
   * @param entities
   * @param <P>
   * @param <E>
   */
  public static <P extends BasePageObject, E extends BaseEntity> void populate(Class<P> pageClass, E... entities) {
    P pageObject = pages.get(pageClass);
    populate(pageObject, entities);
  }
}
