package elements;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.HTML;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>Description:</b> This class contains mapping of existing html form control elements. Mapping
 * is done according to http://www.w3.org/TR/html401/sgml/dtd.html
 * 
 * @author Tim Sukhachev
 * 
 */
public class ControlElement {

  private Type type;

  public enum Type {
    BUTTON, RADIO, TEXT_AREA, SELECT, OPTION, TEXT, LINK, DIV, CHECKBOX
  }

  private static final String BUTTON = "button";
  private static final String RADIO = "radio";
  private static final String TEXT_AREA = "textarea";
  private static final String CHECKBOX = "checkbox";
  private static final String SELECT = "select";
  private static final String OPTION = "option";
  private static final String TEXT = "text";
  private static final String LINK = "a";
  private static final String DIV = "div";

  private static final String NULL = "null";
  private static final String INPUT = "input";
  private static final String PASSWORD = "input";
  private static final String SUBMIT = "submit";
  private static final String HIDDEN = "hidden";
  private static final String RESET = "reset";
  private static final String SELECT_ONE = "select-one";
  private static final String SELECT_MULTIPLE = "select-multiple";

  private final Map<Entry<String, String>, Type> map =
      new HashMap<Entry<String, String>, Type>();
  private final String tagName;
  private final WebElement element;

  public ControlElement(WebElement element) {
    initiateKeyMap();
    this.element = element;
    tagName = element.getTagName().toLowerCase();
    setType();
  }

  private void setType() {
    String typeAttribute = element.getAttribute(HTML.Attribute.TYPE.toString());
    // case when attribute type is not set
    if (typeAttribute == null || typeAttribute.equals(StringUtils.EMPTY)) {
      typeAttribute = NULL;
    }
    Entry<String, String> key =
        new AbstractMap.SimpleEntry<String, String>(tagName, typeAttribute);
    if (map.containsKey(key)) {
      type = map.get(key);
    } else {
      throw new IllegalStateException("Cannot recognise the tag '" + "'" + tagName
          + " and type attribute '" + typeAttribute + "'");
    }
  }

  private void initiateKeyMap() {
    // link
    map.put(new AbstractMap.SimpleEntry<String, String>(LINK, NULL), Type.LINK);
    // div
    map.put(new AbstractMap.SimpleEntry<String, String>(DIV, NULL), Type.DIV);
    // button
    map.put(new AbstractMap.SimpleEntry<String, String>(BUTTON, NULL), Type.BUTTON);
    map.put(new AbstractMap.SimpleEntry<String, String>(BUTTON, SUBMIT), Type.BUTTON);
    map.put(new AbstractMap.SimpleEntry<String, String>(BUTTON, RESET), Type.BUTTON);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, SUBMIT), Type.BUTTON);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, BUTTON), Type.BUTTON);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, RESET), Type.BUTTON);
    // text input
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, TEXT), Type.TEXT);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, PASSWORD), Type.TEXT);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, HIDDEN), Type.TEXT);
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, NULL), Type.TEXT);
    // text area
    map.put(new AbstractMap.SimpleEntry<String, String>(TEXT_AREA, NULL), Type.TEXT_AREA);
    map.put(new AbstractMap.SimpleEntry<String, String>(TEXT_AREA, TEXT_AREA), Type.TEXT_AREA);
    // checkbox
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, CHECKBOX), Type.CHECKBOX);
    // radio
    map.put(new AbstractMap.SimpleEntry<String, String>(INPUT, RADIO), Type.RADIO);
    // select
    map.put(new AbstractMap.SimpleEntry<String, String>(SELECT, NULL), Type.SELECT);
    map.put(new AbstractMap.SimpleEntry<String, String>(SELECT, SELECT_ONE), Type.SELECT);
    map.put(new AbstractMap.SimpleEntry<String, String>(SELECT, SELECT_MULTIPLE), Type.SELECT);
    // option
    map.put(new AbstractMap.SimpleEntry<String, String>(OPTION, NULL), Type.OPTION);
  }

  /**
   * @return the type of html control element
   */
  public Type getType() {
    return type;
  }
}
