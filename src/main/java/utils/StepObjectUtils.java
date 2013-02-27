
package utils;

import net.thucydides.core.pages.Pages;

/**
 * <b>Description:</b> This class represents base marker for step utils
 *
 *
 * @author Tim Sukhachev
 */
public class StepObjectUtils {
  protected static Pages pages;

  public static void setPages(Pages pages) {
    StepObjectUtils.pages = pages;
  }
}
