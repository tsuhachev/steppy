/**
 *
 */
package helper;

import data.entity.BaseEntity;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class EntityHelper {

  /**
   * @param fieldName
   * @param entity
   * @return the string value of field using its getter
   */
  public static String getValueOfField(String fieldName, BaseEntity entity) {
    String errorMessage = "failed to get '" + fieldName + "' value of "
            + entity.getClass().getCanonicalName() + " instance";
    try {
      return (String) PropertyUtils.getProperty(entity, fieldName);
    } catch (IllegalAccessException e) {
      throw new IllegalStateException(errorMessage);
    } catch (InvocationTargetException e) {
      throw new IllegalStateException(errorMessage);
    } catch (NoSuchMethodException e) {
      throw new IllegalStateException(errorMessage);
    }
  }

  /**
   * @param cls
   * @return names of all private and non-static fields defined at cls and its super classes
   */
  public static List<String> getFields(Class cls) {
    List<String> list = new ArrayList<String>();
    for (Class superClass = cls; superClass != Object.class; superClass = superClass.getSuperclass()) {
      Field[] fields = superClass.getDeclaredFields();
      for (Field field : fields) {
        int modifier = field.getModifiers();
        if (!Modifier.isStatic(modifier) && Modifier.isPrivate(modifier)) {
          list.add(field.getName());
        }
      }
    }
    return list;
  }
}
