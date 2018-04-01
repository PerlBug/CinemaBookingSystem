import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CinemaBookingSystem {
	
public static void main(String[] args) {
	CinemaBookingSystem system = new CinemaBookingSystem();
	system.run(args);
}
	
public void run(String[] args) {
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
	        if(commandParts[0].equals("Cinema") || commandParts[0].equals("cinema")) {
	        	System.out.println(commandParts[0]+" "+commandParts[1]+" "+commandParts[2]+" "+commandParts[3]);
	        }else if(commandParts[0].equals("Session") || commandParts[0].equals("session")) {
	        	StringBuilder movie = new StringBuilder();
	        	movie.append(commandParts[3]);
	        	for(int i = 4; i < commandParts.length; i++) {
	        		movie = movie.append(" " + commandParts[i]);
	        	}
	        	commandParts[3] = movie.toString();
	        	System.out.println(commandParts[0]+" "+commandParts[1]+" "+commandParts[2]+" "+commandParts[3]);
	        }
	        else if(commandParts[0].equals("Request") || commandParts[0].equals("request")){
	        	System.out.println(commandParts[0]+" "+commandParts[1]+" "+commandParts[2]+" "+commandParts[3]+" "+commandParts[4]);
	        }else if(commandParts[0].equals("Change") || commandParts[0].equals("change")){
	        	System.out.println(commandParts[0]+" "+commandParts[1]+" "+commandParts[2]+" "+commandParts[3]+" "+commandParts[4]);
	        }else if(commandParts[0].equals("Cancel") || commandParts[0].equals("cancel")){
	        	System.out.println(commandParts[0]+" "+commandParts[1]);
	        }else if(commandParts[0].equals("Print") || commandParts[0].equals("print")){
	        	System.out.println(commandParts[0]+" "+commandParts[1]+" "+commandParts[2]);
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
	
}