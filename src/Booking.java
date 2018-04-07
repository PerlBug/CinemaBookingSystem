import java.util.ArrayList;

public class Booking {
	private int bookingNum;
	private Cinema cinemaBooked;
	private Session sessionBooked; 
	private Row rowBooked;
	private ArrayList<Seat> seatsBooked;
	private int numOfSeatsBooked;
	private int startSeat;
	private int endSeat;
	
	public Booking(int bookingNum, Cinema cinemaBooked, Session sessionBooked, int numOfSeatsBooked) {
		this.bookingNum = bookingNum;
		this.cinemaBooked = cinemaBooked;
		this.sessionBooked = sessionBooked;
		this.numOfSeatsBooked = numOfSeatsBooked;		
	} 
	
	public boolean anySeatTaken(ArrayList<Seat> currSeats) {
		
		for(int i = 0; i < currSeats.size(); i++) {
			if(!currSeats.get(i).isReserved()) {
				continue;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public boolean makeBooking() {
		seatsBooked = new ArrayList<Seat>();
		ArrayList<Row> cinemaRows = cinemaBooked.getRows();
		ArrayList<Seat> currSeats = new ArrayList<>();
		int n = numOfSeatsBooked - 1;

		for(Row currRow : cinemaRows) {
				for(int i = 0; i < currRow.getNumOfSeats() - n; i++) {
					int firstSeat = i;
					int lastSeat = i + n;
					//System.out.println(currRow.getSeatByIndex(i).getSeatId() + " starts " + firstSeat + " ends " + lastSeat);
					
					for(int j = firstSeat;j <=lastSeat; j++) { //get individual seats						
						currSeats.add(currRow.getSeatByIndex(j));					
						System.out.print(currRow.getSeatByIndex(j).getSeatId() + currRow.getSeatByIndex(j).isReserved() + " ");
						
					}
					System.out.println("");
					System.out.println(currSeats);
					if(anySeatTaken(currSeats)) {
						currSeats.clear();
						continue;
					}else {
						seatsBooked = currSeats;
						return true;
					}
										
					
						
					
				}
			}
					
			
			
		
		return false;
		
	}
	
	public void printBookedSeats() {
		System.out.println("Seats Booked: ");
		for(Seat seat: seatsBooked) {
			System.out.print(seat.getSeatId() + " ");
		}
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
