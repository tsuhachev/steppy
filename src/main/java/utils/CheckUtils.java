
package utils;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import page.BasePageObject;

/**
 * <b>Description:</b> This class represents generic steps used for verification
 * @author Tim Sukhachev
 */
public class CheckUtils {

  @Step
  public static void fieldValueIs(String field, String value, BasePageObject pageObject) {
    Assert.assertEquals(pageObject.getValue(field), value);
  }
}
