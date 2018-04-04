
public class Booking {
	private int bookingNum;
	private int cinemaNum;
	private Session session; 
	private Row rowsBooked;
	private int numOfSeatsBooked;
	private int startSeat;
	private int endSeat;
	
	public Booking(int bookingNum, int cinemaNum, Session session, int numOfSeatsBooked) {
		this.bookingNum = bookingNum;
		this.cinemaNum = cinemaNum;
		this.session = session;
		this.numOfSeatsBooked = numOfSeatsBooked;
		
	} 
	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("Booking Num: " + bookingNum);
		System.out.println("Cinema Num " + cinemaNum);
		System.out.println("For session: " + session.getMovie() +" at " + session.getTime());
		System.out.println("Num of seats booked: " + numOfSeatsBooked);
		System.out.println("------------------------------");

	}
	
	
	
}
