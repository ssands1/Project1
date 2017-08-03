// import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class User {
	public User(String username, String password) throws IOException {
		StringBuilder sb = new StringBuilder();
		//sb.append("\"");
		sb.append(username);
		sb.append(',');
		sb.append(password);
		//sb.append("\"");
		sb.append("\n");

		FileWriter fw = new FileWriter("users.csv", true);
		fw.append(sb.toString());
		fw.close();
	}

	// gets password for given user by reading csv to treemap, getting password
	public static String getPassword(String username) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("users.csv"));
		scan.useDelimiter(",");

		TreeMap<String, String> userMap = new TreeMap<String, String>();
		//while (scan.hasNextLine()) {
		String user = "";
		for (int i = 0; i < 1; i++) {
			user = scan.next();
			System.out.println(user);
			String password = scan.next();
			System.out.println(password);
			userMap.put(user, password);
			System.out.println(userMap.get(user));
		}
		scan.close();
		System.out.println("Length: "+userMap.size());
		return userMap.get(user);
	}

	// reads csv into treemap, writes treemap to csv
	public static void sort(){

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Name:");
		String username = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		scan.close();

		try {
			User user = new User(username, password);
		} catch (IOException e) {
			e.printStackTrace();
		}		

		try {
			System.out.println("\n\nThe passwor for spencedawg123 is: " + getPassword("spencedawg123"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}