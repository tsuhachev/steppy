/**
 *
 */
package data.entity;

/**
 * <b>Description:</b> This class ...
 * <br/><br/><b>Data Model Entity:</b> none
 * <br/><br/><b>Configuration:</b> none
 * <br/><br/><b>Known Issues:</b> none
 *
 * @author Tim Sukhachev
 */
public class Ticket extends BaseEntity {

  private String destination;
  public static final String DESTINATION = "destination";
  private String departureTime;
  public static final String DEPARTURE_DATE = "departureTime";
  private String ticketClass;

  public String getTicketClass() {
    return ticketClass;
  }

  public void setTicketClass(String ticketClass) {
    this.ticketClass = ticketClass;
  }

  public static final String TICKET_CLASS = "ticketClass";

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }
}
