/**
 *
 */
package data.entity;

/**
 * <b>Description:</b> This class represents Passenger entity
 *
 * @author Tim Sukhachev
 */
public class Passenger extends BaseEntity {
  public static final String NAME = "name";
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
