import java.util.ArrayList;

public class Session {
	private String movie;
	private String time;
	private int cinemaNum;
	private ArrayList<Row> sessionRows;
	private ArrayList<Booking> bookings;
	
	
	public Session(int cinemaNum, String time, String movie, ArrayList<Row> sessionRows) {
		this.movie = movie;
		this.time = time;
		this.cinemaNum = cinemaNum;
		bookings = new ArrayList<Booking>();
		this.setSessionRows(sessionRows);
	}
	
	public Session(int cinemaNum, String time, String movie) {
		this.movie = movie;
		this.time = time;
		this.cinemaNum = cinemaNum;
		bookings = new ArrayList<Booking>();
		sessionRows = new ArrayList<Row>();
	}
	



	public void addBookingToList(Booking booking) {
		bookings.add(booking);
	}
	
	public void printSessionRows() {
		for(Row row:sessionRows) {
			for(Seat seat: row.getSeats()) {
				System.out.print(seat.getSeatId() + seat.isReserved() +" ");
			}
			System.out.println(" ");
		}
	}
	public void print() {
		System.out.println("The movie " + movie + " is playing at "+ time + " at cinema " + cinemaNum);
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCinemaNum() {
		return cinemaNum;
	}

	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}



	public ArrayList<Row> getSessionRows() {
		return sessionRows;
	}



	public void setSessionRows(ArrayList<Row> sessionRows) {
		this.sessionRows = sessionRows;
	}
	
	
	
}
