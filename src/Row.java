import java.util.ArrayList;

public class Row {
	private String rowID; 
	private ArrayList<Seat> seats;
	private int availSeats;
	
	public Row(String rowID, int numOfSeats) {
		this.rowID = rowID;
		seats = new ArrayList<Seat>();
		for(int i = 1; i <= numOfSeats; i++) {
			seats.add(new Seat(i, this));
		}
	}

	
	
	public String getRowID() {
		return rowID;
	}
	
	public Seat getSeatByIndex(int i) {
		return seats.get(i);
	}
	
	public void setRowID(String rowID) {
		this.rowID = rowID;
	}
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
	public int getNumOfSeats() {
		return seats.size();
	}
	
	public int getAvailSeats() {
		return availSeats;
	}
	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	} 
	public void print() {
		System.out.print(rowID+":");
		for(Seat seat:getSeats()) {
			
		}
	}
	
	
	
	public Seat findSeatBySeatID(String ID) {
		for(Seat seat: seats) {
			if(seat.getSeatId().equals(ID)) {
				return seat;
			}
		}
		return null;
	}
	
}
