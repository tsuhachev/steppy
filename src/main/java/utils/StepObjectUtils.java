/**
 *
 */
package utils;

import net.thucydides.core.pages.Pages;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class StepObjectUtils {
  private static Pages pages;

  public static Pages getPages() {
    return pages;
  }

  public static void setPages(Pages pages) {
    StepObjectUtils.pages = pages;
  }
}
