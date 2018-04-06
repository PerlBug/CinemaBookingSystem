import java.util.ArrayList;

public class Row {
	private String rowID; 
	private ArrayList<Seat> seats;
	private int availSeats;
	
	public Row(String rowID) {
		this.rowID = rowID;
		seats = new ArrayList<Seat>();
	}
	
	public void addSeatsToRow(int numOfSeats){
		for(int i = 1; i <= numOfSeats; i++) {
			seats.add(new Seat(i));
		}
	}
	
	public String getRowID() {
		return rowID;
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
		System.out.println("Row " + getRowID()+ " has "+getSeats().size() + " seats");
	}
	
}
