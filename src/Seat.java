
public class Seat {
	private Row row;
	private int seatNum;
	private String seatID;
	private boolean reserved;
	
	
	public Seat(int seatNum, Row row) {
		this.seatNum = seatNum;
		this.setRow(row);
		this.reserved = false;
		this.seatID = row.getRowID() + seatNum;
		
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
		
		return seatID;
	}
	
	public void print() {
		System.out.print(seatID + isReserved() + " ");
	}
	public Row getRow() {
		return row;
	}
	public void setRow(Row row) {
		this.row = row;
	}
	
}
