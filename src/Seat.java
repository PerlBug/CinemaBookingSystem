
public class Seat {
	private int seatNum;
	private boolean reserved;
	
	
	public Seat(int seatNum) {
		this.seatNum = seatNum;
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
	
}
