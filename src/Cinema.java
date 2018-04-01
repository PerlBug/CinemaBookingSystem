import java.util.ArrayList;

public class Cinema {
	private int cinemaNum;
	private ArrayList<Row> rows;
	private ArrayList<Session> sessions;
	
	public Cinema(int cinemaNum) {
		this.cinemaNum = cinemaNum;
		rows = new ArrayList<Row>();
		sessions = new ArrayList<Session>();
	}
	public void addRow(Row row) {
		rows.add(row);
	}
	public int getCinemaNum() {
		return cinemaNum;
	}
	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}
	public ArrayList<Row> getRows() {
		return rows;
	}
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void print() {
		System.out.println("Cinema number: " + getCinemaNum()+ " has " +getNumOfRows()+" rows"); 
		for(Row row : rows) {
			System.out.println("Row: " + row.getRowID()+ " has "+row.getSeats().size() + " seats");
		}
	}
	public int getNumOfRows() {
		return rows.size();
	}
	
	public boolean hasRow(String ID) {
		for(Row row: rows) {
			if(row.getRowID().equals(ID)) {
				return true;
			}
		}
		return false;
	}	
}
