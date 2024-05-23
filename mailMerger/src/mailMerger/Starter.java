package mailMerger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
showMenu();
	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		List<Student> allStudents = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int choice=0;
		System.out.println("Starting Menu");
		for(int i =0; i<7; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf(".");
		}
		
		System.out.println("\n\nWelcome");
		do {
			System.out.println("\nPlease choose from the following options and press enter...");
			System.out.println("1)Load File");
			System.out.println("2)Display size of current list");
			System.out.println("3)Find all students that had an invalid logOn duration");
			System.out.println("4)Display full details of all students in current list");
			System.out.println("5)Create files for message template for each student");
			System.out.println("6)Quit");
			
			choice = sc.nextInt();
			switch(choice){
				
				case 1:
					allStudents= processLines(readFile("input.csv"));
					break;
				case 2:
					displaySize(allStudents);
					break;
				case 3:
					displayAll(getInvalidLogTimeList(allStudents));
					
					break;
				case 4:
					displayAll(allStudents);
					break;
				case 5:
					createAllFiles(getInvalidLogTimeList(allStudents));
					break;
				case 6:
					break;
					default :
					System.err.println("Invalid input - try again");
					
			}
		} while(choice!=6);
		sc.close();
	}

	private static void createAllFiles(List<Student> allStudents) {
		for(Student s : allStudents) {
		callToWriter(s);}
		
	}

	private static void callToWriter(Student s) {
		WriteToFile writer = new WriteToFile(s);
		Thread t = new Thread(writer);
		t.start();
	}

	public static void displayAll(List<Student> allStudents) {
		// TODO Auto-generated method stub
		System.out.println("Displaying all students in the current list");
		for(Student s : allStudents) {
			System.out.println(s.toString());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List<Student> getInvalidLogTimeList(List<Student> allStudents) {
         List<Student>	results = new ArrayList<Student>();
		for(Student  s : allStudents) {
			if(!s.minTimeLogged()) {
				results.add(s);
			}
		}return results;
	}

	private static void displaySize(Collection<Student> allStudents) {
		// TODO Auto-generated method stub
		System.out.println(allStudents.size());
	}

	public static List<Student> processLines(List<String> allLines) {
		List<Student> allStudents = new ArrayList<Student>();

		for (String line : allLines) {
			try {
				String[] parts = line.split(",");
				String name = parts[0];
				String studentNumber = parts[1];
				String logOnTime = parts[2];
				String logOffTime = parts[3];
				String  emailAddress = parts[4];
				
				Student s = new Student(name, studentNumber, logOnTime, logOffTime, emailAddress);
			    allStudents.add(s);
			
				
				
			} catch (Exception e) {
				e.printStackTrace();

				System.err.println(allStudents.size()
						+ " lines read so far (and corresponding object created, encountered bad data skipping current line...)");
			}

		}
		return allStudents;
	}

	public static List<String> readFile(String fileName) {
		List<String> allLines = new ArrayList<>();
		
		try {
			
			File myFile = new File(fileName);
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if(line.contains("name,student number,logon,logoff,email")){
				line = br.readLine();
			} while(line!=null) {
				allLines.add(line.trim());
				line = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allLines;
		
	}

}
