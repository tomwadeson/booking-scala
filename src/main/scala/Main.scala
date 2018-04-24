import java.time.LocalDate

import BookingSystem._
import Domain._

object Main extends App {

  val booking = Booking(List(
    Room("1", 0, view = true, capacity = 5, price = 100.0, rating = 3.2, booked = List.empty),
    Room("2", 0, view = true, capacity = 3, price = 150.0, rating = 9.2, booked = List(Reservation(1, Period(LocalDate.now(), LocalDate.now().plusDays(1)), Guest("john","senior")))),
    Room("3", 0, view = false, capacity = 3, price = 120.0, rating = 8.4, booked = List(Reservation(1, Period(LocalDate.now(), LocalDate.now().plusDays(1)), Guest("john","major")))),
    Room("4", 0, view = true, capacity = 4, price = 140.0, rating = 7.2, booked = List.empty),
    Room("5", 0, view = true, capacity = 4, price = 140.0, rating = 4.6, booked = List.empty)
  ))

  val best: Room = proposeBest(booking)
  println(s"Best: $best and cost per person is: ${costPerPersonForBest(booking)}")
  assert(best.no == "4")

}
