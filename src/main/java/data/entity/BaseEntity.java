/**
 *
 */
package data.entity;

import utils.EntityUtils;

import java.util.List;

/**
 * <b>Description:</b> This class is just an entity marker
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class BaseEntity {

  @Override
  public String toString() {
    String str = "";
    List<String> fields = EntityUtils.getFields(this.getClass());
    for (String field : fields) {
      String value = EntityUtils.getValueOfField(field, this);
      if (value != null) {
        str = str + "[" +field + ":" + value + "] ";
      }
    }
    return str;
  }
}
