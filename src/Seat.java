
public class Seat {
	private Row row;
	private int seatNum;
	private boolean reserved;
	
	
	public Seat(int seatNum, Row row) {
		this.seatNum = seatNum;
		this.row = row;
		this.reserved = false;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	public String getSeatId() {
		
		return row.getRowID() + seatNum;
	}
	
}
