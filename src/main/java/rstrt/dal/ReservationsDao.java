package rstrt.dal;

public class ReservationsDao {
  public Reservations create(Reservations reservation)
  public Reservations getReservationById(int reservationId)
  public List<Reservations> getReservationsByUserName(String userName)
  public List<Reservations> getReservationsBySitDownRestaurantId(int sitDownRestaurantId)
  public Reservations delete(Reservations reservation)

}
