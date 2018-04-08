import java.util.ArrayList;

public class Booking {
	private int bookingNum;
	private Cinema cinemaBooked;
	private Session sessionBooked; 
	private Row rowBooked;
	private ArrayList<Seat> seatsBooked;
	private int numOfSeatsBooked;
	
	
	public Booking(int bookingNum, Cinema cinemaBooked, Session sessionBooked, int numOfSeatsBooked) {
		this.bookingNum = bookingNum;
		this.cinemaBooked = cinemaBooked;
		this.sessionBooked = sessionBooked;
		this.numOfSeatsBooked = numOfSeatsBooked;
	} 
	public Booking() {
		
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
	
	public void cancelBooking() {
		
		ArrayList<Row> rows = sessionBooked.getSessionRows();	
		for(Row row: rows) {
			if(row.getSeats().containsAll(seatsBooked)) {
				for(Seat seat: row.getSeats()) {
					seat.setReserved(false);
				}
			}
		}
		System.out.println("Cancel " + bookingNum);

	
		
	}
	
	public boolean changeBooking(Session oldSession, Session newSession, Cinema cinemaBooked,int numOfSeatsBooked) {
		//find old session and free seats
		ArrayList<Row> rows = oldSession.getSessionRows();	
		for(Row row: rows) {
			if(row.getSeats().containsAll(seatsBooked)) {
				for(Seat seat: row.getSeats()) {
					seat.setReserved(false);
				}
			}
		}
		
		//book new session
		this.sessionBooked = newSession;
		this.cinemaBooked = cinemaBooked;
		this.numOfSeatsBooked = numOfSeatsBooked;
		return makeBooking();
		
		
		
		
		
	}
	public boolean makeBooking() {
		
		seatsBooked = new ArrayList<Seat>();
		ArrayList<Row> cinemaRows = sessionBooked.getSessionRows();
		ArrayList<Seat> currSeats = new ArrayList<>();
		int n = numOfSeatsBooked - 1;

		for(Row currRow : cinemaRows) {
				for(int i = 0; i < currRow.getNumOfSeats() - n; i++) {
					int firstSeat = i;
					int lastSeat = i + n;
					//System.out.println(currRow.getSeatByIndex(i).getSeatId() + " starts " + firstSeat + " ends " + lastSeat);
					
					for(int j = firstSeat;j <=lastSeat; j++) { //get individual seats
						
						currSeats.add(currRow.getSeatByIndex(j));					
						//System.out.print(currRow.getSeatByIndex(j).getSeatId() + currRow.getSeatByIndex(j).isReserved() + " ");
						
					}
					//System.out.println("");
					//System.out.println(currSeats);
					if(anySeatTaken(currSeats)) {
						currSeats.clear();
						continue;
					}else {
						seatsBooked = currSeats;
						for(Seat seat: seatsBooked) {
							seat.setReserved(true);
						}
						setRowBooked(seatsBooked.get(0).getRow());
						return true;
					}
										
					
						
					
				}
			}
					
			
			
		
		return false;
		
	}
	public void printChangedSeats() {
		System.out.println("Change "+ getBookingNum() + " " +seatsBooked.get(0).getSeatId()+"-"+seatsBooked.get(seatsBooked.size()-1).getSeatId());

	}
	public void printBookedSeats() {
		if(numOfSeatsBooked > 1) {
			System.out.println("Booking "+ getBookingNum() + " " +seatsBooked.get(0).getSeatId()+"-"+seatsBooked.get(seatsBooked.size()-1).getSeatId());

		} else {
			System.out.println("Booking "+ getBookingNum() + " " +seatsBooked.get(0).getSeatId());
		}
	
	}
	
	public void print() {
		if(numOfSeatsBooked > 1) {
			System.out.print(seatsBooked.get(0).getSeatNum()+"-"+seatsBooked.get(seatsBooked.size()-1).getSeatNum());

		} else {
			System.out.print(seatsBooked.get(0).getSeatNum());
		}

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
	


	
}
