
package data.entity;

/**
 * <b>Description:</b> This class represents Ticket entity
 * @author Tim Sukhachev
 */
public class Ticket extends BaseEntity {

  private String destination;
  public static final String DESTINATION = "destination";
  private String departureDate;
  public static final String DEPARTURE_DATE = "departureDate";
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

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }
}
