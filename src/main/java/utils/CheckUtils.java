
package utils;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import page.BasePageObject;

/**
 * <b>Description:</b> This class represents generic steps used for verification
 * @author Tim Sukhachev
 */
public class CheckUtils extends StepObjectUtils {

  @Step
  public static <P extends BasePageObject> void fieldValueIs(String field, String value, final Class<P> pageObjectClass) {
    P pageObject = getPages().get(pageObjectClass);
    Assert.assertEquals(pageObject.getValue(field), value);
  }
}
