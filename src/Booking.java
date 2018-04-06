import java.util.ArrayList;

public class Booking {
	private int bookingNum;
	private Cinema cinemaBooked;
	private Session sessionBooked; 
	private Row rowBooked;
	private ArrayList<String> seatIDsBooked;
	private int numOfSeatsBooked;
	private int startSeat;
	private int endSeat;
	
	public Booking(int bookingNum, Cinema cinemaBooked, Session sessionBooked, int numOfSeatsBooked) {
		this.bookingNum = bookingNum;
		this.cinemaBooked = cinemaBooked;
		this.sessionBooked = sessionBooked;
		this.numOfSeatsBooked = numOfSeatsBooked;
		seatIDsBooked = new ArrayList<String>();
		
	} 
	
	
	public boolean makeBooking() {
		ArrayList<Row> cinemaRows = cinemaBooked.getRows();
		int n = numOfSeatsBooked - 1;
		boolean ableToBook;
		for(Row currRow : cinemaRows) {
			
			for(int i = 0; i < currRow.getNumOfSeats() - n; i++) {
				int firstSeat = i;
				int lastSeat = i + n;
				//System.out.println(currRow.getSeatByIndex(i).getSeatId() + " starts " + firstSeat + " ends " + lastSeat);
				for(int j = firstSeat;j <=lastSeat; j++) {
					ableToBook = true;
					
					if(currRow.getSeatByIndex(j).isReserved() == true) {
						ableToBook = false;
					}
					
					System.out.print(currRow.getSeatByIndex(j).getSeatId() + " ");
				}
				System.out.println();
					
				
			}
			System.out.println("--------------------------");
		}
				
		
		return false;
	}
	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("Booking Num: " + bookingNum);
		System.out.println("Cinema Num " + cinemaBooked.getCinemaNum());
		System.out.println("For session: " + sessionBooked.getMovie() +" at " + sessionBooked.getTime());
		System.out.println("Num of seats to book: " + numOfSeatsBooked);
		System.out.println("------------------------------");

	}


	public int getBookingNum() {
		return bookingNum;
	}


	public void setBookingNum(int bookingNum) {
		this.bookingNum = bookingNum;
	}


	public Cinema getCinemaBooked() {
		return cinemaBooked;
	}


	public void setCinemaBooked(Cinema cinemaBooked) {
		this.cinemaBooked = cinemaBooked;
	}


	public Session getSessionBooked() {
		return sessionBooked;
	}


	public void setSessionBooked(Session sessionBooked) {
		this.sessionBooked = sessionBooked;
	}


	public Row getRowBooked() {
		return rowBooked;
	}


	public void setRowBooked(Row rowBooked) {
		this.rowBooked = rowBooked;
	}


	public int getNumOfSeatsBooked() {
		return numOfSeatsBooked;
	}


	public void setNumOfSeatsBooked(int numOfSeatsBooked) {
		this.numOfSeatsBooked = numOfSeatsBooked;
	}


	public int getStartSeat() {
		return startSeat;
	}


	public void setStartSeat(int startSeat) {
		this.startSeat = startSeat;
	}


	public int getEndSeat() {
		return endSeat;
	}


	public void setEndSeat(int endSeat) {
		this.endSeat = endSeat;
	}
	
	
	
	
	
}
