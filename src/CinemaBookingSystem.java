import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaBookingSystem {

	ArrayList<Cinema> cinemas;
	ArrayList<Booking> bookings;

public static void main(String[] args) {
	CinemaBookingSystem system = new CinemaBookingSystem();
	system.run(args);
}
public CinemaBookingSystem(){
	cinemas = new ArrayList<Cinema>();
	bookings = new ArrayList<Booking>();
}

public void run(String[] args) {
	ArrayList<Row> rowCopy = new ArrayList<Row>();
	Scanner sc = null;
    try
    {
        sc = new Scanner(new File(args[0]));// args[0] is the first command line argument
        String line; 
        while(sc.hasNextLine()) {
        	line = sc.nextLine();
	        String[] lineParts = line.split("#");
	        String command = lineParts[0].trim();
	        String[] commandParts = command.split("\\s"); 
	        //All possible cases for commands.
	        //CINEMA COMMAND
	        if(commandParts[0].equals("Cinema") || commandParts[0].equals("cinema")) {
	        	//creating local variables from commandParts array
	        	int cinemaNum = Integer.parseInt(commandParts[1]);
	        	String rowID = commandParts[2];
	        	int numOfSeats = Integer.parseInt(commandParts[3]);
	        	Row row = new Row(rowID,numOfSeats);
	        	

	        	if(!hasCinema(cinemaNum)) {	        		
	        		Cinema newCinema = new Cinema(cinemaNum);
	        		if(!newCinema.hasRow(rowID)) {
	        			newCinema.addRow(row);
	        		}
	        		
	        		cinemas.add(newCinema);
	        	}else {
	        		Cinema existingCinema = findCinemaByNum(cinemaNum);
	        		if(!existingCinema.hasRow(rowID)) {
	        			existingCinema.addRow(row);
	        		}
	        		
	        	}
	        //SESSION COMMAND
	        }else if(commandParts[0].equals("Session") || commandParts[0].equals("session")) {
	        	int cinemaNum = Integer.parseInt(commandParts[1]);
	        	
	        	String time = commandParts[2];
	        	StringBuilder movie = new StringBuilder();
	        	movie.append(commandParts[3]);
	        	for(int i = 4; i < commandParts.length; i++) {
	        		movie = movie.append(" " + commandParts[i]);
	        	}
	        	String movieString = movie.toString();
	        	for(Row row: findCinemaByNum(cinemaNum).getRows()) {
	        		rowCopy.add(new Row(row.getRowID(),row.getNumOfSeats()));
	        		
	        	}
	        	Session session = new Session(cinemaNum,time, movieString,rowCopy);        	
	        	findCinemaByNum(cinemaNum).addSession(session);
	        	rowCopy.clear();
	        	
	        }
	        //REQUEST COMMAND
	        else if(commandParts[0].equals("Request") || commandParts[0].equals("request")){
	        	int bookingNum = Integer.parseInt(commandParts[1]);
	        	int cinemaNum = Integer.parseInt(commandParts[2]);
	        	String sessionTime = commandParts[3];
	        	int numOfSeats = Integer.parseInt(commandParts[4]);
	        	
	        	//Find cinema by num 
	        	Cinema cinemaGiven = findCinemaByNum(cinemaNum);
	        	//Find session by time 
	        	
	        	Session sessionGiven = cinemaGiven.getSessionByTime(sessionTime);
	        	
	        	Booking newBooking = new Booking(bookingNum, cinemaGiven, sessionGiven, numOfSeats);
	        	
	        	sessionGiven.addBookingToList(newBooking);
	        	bookings.add(newBooking);
	        	
	        	//sessionGiven.printSessionRows();
	        	if(!newBooking.makeBooking()) {
	        		System.out.println("Booking rejected");
	        	}else {
	        		newBooking.printBookedSeats();
	        	}
	        	
	        //CHANGE COMMAND
	        }else if(commandParts[0].equals("Change") || commandParts[0].equals("change")){
	        	
	        	int bookingNum = Integer.parseInt(commandParts[1]);
	        	int cinemaNum = Integer.parseInt(commandParts[2]);
	        	String sessionTime = commandParts[3];
	        	int numOfTickets = Integer.parseInt(commandParts[4]);
	        	Cinema cinemaGiven = findCinemaByNum(cinemaNum);
	        	ArrayList<Session> sessions = cinemaGiven.getSessions();
	        	Booking oldBooking = new Booking();
	        	
        		for(Booking booking : bookings) {
        			if(booking.getBookingNum() == bookingNum) {
        				oldBooking = booking;
        			} 
        		}
	        
	        	Session oldSession = oldBooking.getSessionBooked();
	        	Session sessionToChangeTo = cinemaGiven.getSessionByTime(sessionTime);
	        	boolean changedSuccess = oldBooking.changeBooking(oldSession, sessionToChangeTo, cinemaGiven, numOfTickets);
	        	
	        	if(changedSuccess) {
	        		oldBooking.printChangedSeats();
		        	sessionToChangeTo.addBookingToList(oldBooking);

	        	} else {
	        		System.out.println("Change rejected");
	        	}
	        	
	        }
	        //CANCEL COMMAND
	        else if(commandParts[0].equals("Cancel") || commandParts[0].equals("cancel")){
	        	int bookingNum = Integer.parseInt(commandParts[1]);
	        	Booking oldBooking = new Booking();
	        	
	        	for(Booking booking : bookings) {
	        		if(booking.getBookingNum() == bookingNum) {
	        			oldBooking = booking;
	        		}
	        	}
	        	
	        	oldBooking.cancelBooking();
	        	
	        	

	        //PRINT COMMAND
	        }else if(commandParts[0].equals("Print") || commandParts[0].equals("print")){
	        	int cinemaNum = Integer.parseInt(commandParts[1]);
	        	String sessionTime = commandParts[2];
	        	
	        	Session session = findCinemaByNum(cinemaNum).getSessionByTime(sessionTime);
	        	session.print();
	        }
        }
    }
    catch (FileNotFoundException e)
    {
        System.out.println(e.getMessage());
    }
    finally
    {
    	if (sc != null) sc.close();
    }
    
}

public boolean hasCinema(int num) {
	
	for(Cinema x: cinemas) {
		if(num == x.getCinemaNum()) {
			return true;
		}
	}
	
	return false;
}

public Cinema findCinemaByNum(int num) {
	for(Cinema cinema: cinemas) {
		if(cinema.getCinemaNum() == num){
			return cinema;
		}
	}
	return null;
}

public void print() {
	for(Cinema cinema: cinemas) {
		cinema.print();
	}
}

	
}
