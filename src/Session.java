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
		this.sessionRows = new ArrayList<>();
		for(Row row:sessionRows) {
			this.sessionRows.add(new Row(row.getRowID(), row.getNumOfSeats()));
		}
	}

	public Booking getBookingByNum(int num) {
		
		for(Booking booking: bookings) {
			if(booking.getBookingNum() == num) {
				return booking;
			}
		}
		return null;
	}

	public void addBookingToList(Booking booking) {
		bookings.add(booking);
	}
	
	public void printSessionRows() {
		for(Row row:sessionRows) {
			for(Seat seat: row.getSeats()) {
				System.out.print(seat.getSeatId() + seat.isReserved() + " ");
			}
			System.out.println();

		}
		System.out.println("no of bookings "+ bookings.size());
	}
	public void print() {
		System.out.println(movie);
		ArrayList<Booking> printedBookings = new ArrayList<>();
		for(Row row: sessionRows) {
			System.out.print(row.getRowID()+":");
			System.out.print(" ");
			
			for(Booking booking:bookings) {
				if(booking.getRowBooked().getRowID().equals(row.getRowID())) {
					booking.print();
					printedBookings.add(booking);
					break;
				}
			}
			
			
			
			for(int i = 0; i < bookings.size(); i++) {
				if(bookings.get(i).getRowBooked().getRowID().equals(row.getRowID()) && !printedBookings.contains(bookings.get(i))) {
					System.out.print(",");
					bookings.get(i).print();
				}
			}
			
			
			
			System.out.println();
		}
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
	
	public void printBookings() {
		System.out.println("no of bookings made for the "+ getMovie()+ " session: " + bookings.size());
	}
	
	
	
}
