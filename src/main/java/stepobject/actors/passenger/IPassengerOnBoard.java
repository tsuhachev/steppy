/**
 *
 */
package stepobject.actors.passenger;

import data.entity.Ticket;

/**
 * <b>Description:</b> This class maps passenger steps upon Board feature
 *
 * @author Tim Sukhachev
 */
public interface IPassengerOnBoard {

  void takesThePlace(Ticket ticket);

  void enjoysTheFlight();
}
