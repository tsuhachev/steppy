
package utils;

import org.junit.Assert;
import page.BasePageObject;

/**
 * <b>Description:</b> This class represents generic steps used for verification
 * @author Tim Sukhachev
 */
public class CheckUtils extends StepObjectUtils {

  public static <P extends BasePageObject> void fieldValueIs(final Class<P> pageObjectClass, String field, String value) {
    P pageObject = pages.get(pageObjectClass);
    Assert.assertEquals(pageObject.getValue(field), value);
  }
}
