package readers;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("What is your name?");
			String name = reader.readLine();
			
			System.out.println("What is your job?");
			String job = reader.readLine();
			
			System.out.format("%s, %s", name, job);
		}
		catch(IOException ioe) {
			System.out.println("IO in bufferedReader in main");
			ioe.printStackTrace();
		}
	}

}
