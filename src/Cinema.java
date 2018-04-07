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
	
	public Session getSessionByTime(String time) {
		for(Session sesh: sessions) {
			if(sesh.getTime().equals(time)) {
				return sesh;
			}
		}
		return null;
	}
	
	public ArrayList<Row> deepCopyRow(){
		ArrayList<Row> copy = new ArrayList<>();
		for(Row row: rows) {
			copy.add(new Row(row.getRowID()));
		}
		return copy;
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
		System.out.println("Cinema " + getCinemaNum()+ " has " +getNumOfRows()+" rows as follows:"); 
		for(Row row : rows) {
			row.print();
		}
		System.out.println("Cinema " + getCinemaNum()+ " has the following sessions: " );
		for(Session session : sessions) {
			session.print();
		}
		System.out.println("--------------------------------");
		
		
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
	
	public void addSession(Session session) {
		sessions.add(session);
	}
	
	
}
