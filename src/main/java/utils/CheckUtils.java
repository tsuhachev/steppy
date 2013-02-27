
package utils;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import page.BasePageObject;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class CheckUtils {

  @Step
  public static void fieldValueIs(String field, String value, BasePageObject pageObject) {
    Assert.assertEquals(pageObject.getValue(field), value);
  }
}
