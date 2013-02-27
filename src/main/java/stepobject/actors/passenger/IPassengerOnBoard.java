/**
 *
 */
package stepobject.actors.passenger;

import data.entity.Ticket;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public interface IPassengerOnBoard {

  void takesThePlace(Ticket ticket);

  void enjoysTheFlight();
}
