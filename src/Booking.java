import java.util.ArrayList;

public class Booking {
	private int bookingNum;
	private Cinema cinemaBooked;
	private Session sessionBooked; 
	private Row rowBooked;
	private int numOfSeatsBooked;
	private int startSeat;
	private int endSeat;
	
	public Booking(int bookingNum, Cinema cinemaBooked, Session sessionBooked, int numOfSeatsBooked) {
		this.bookingNum = bookingNum;
		this.cinemaBooked = cinemaBooked;
		this.sessionBooked = sessionBooked;
		this.numOfSeatsBooked = numOfSeatsBooked;
		
	} 
	
	
	public boolean makeBooking() {
		ArrayList<Row> cinemaRows = cinemaBooked.getRows();
		int n = numOfSeatsBooked;
		for(Row currRow : cinemaRows) {
			
			for(int i = 0; i < currRow.getNumOfSeats(); i++) {
				
			}
			
		}
				
		
		return false;
	}
	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("Booking Num: " + bookingNum);
		System.out.println("Cinema Num " + cinemaBooked.getCinemaNum());
		System.out.println("For session: " + sessionBooked.getMovie() +" at " + sessionBooked.getTime());
		System.out.println("Num of seats booked: " + numOfSeatsBooked);
		System.out.println("------------------------------");

	}
	
	
	
}
