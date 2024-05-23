package woofChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		//Test
//Dog d = new Dog("labrador", "Blonde", "Scotland", 6.2, 50.6, 13);
//System.out.println(d.toString());

		showMenu();
	}

	public static void showMenu() {
		// TODO Auto-generated method stub
		List<Dog> allDogs=null;
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		System.out.println("Starting App");
		for (int i = 0; i < 7; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf(".");
		}
		do {

			System.out.println("\nPlease choose from one of the following options and press enter");
			System.out.println("1)Load Dog List");
			System.out.println("2)Show All Dogs In List");
			System.out.println("3)Order And Show By Height (Tallest First)");
			System.out.println("4)Order And Show by Weight (Heaviest First)");
			System.out.println("5)Group and show by Country (Frequency of breeds from each country)");
			System.out.println("6).................................................................");
			System.out.println("7) Exit");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				allDogs = processLines(readFile("DogData.csv"));
				System.out.println(allDogs.size()+" Dogs in current list");
				System.out.println();
				break;
			case 2:
				displayAll(allDogs);
				break;
			case 3:
				displayAll(sortedSubListByAttribute(allDogs, allDogs.size(), "Height"));
				break;
			case 4:
				displayAll ( sortedSubListByAttribute(allDogs,allDogs.size(),"Weight"));
				break;

			case 5:
				Map<String,Integer> countryMap = groupByCountry(allDogs);
				displayMap(countryMap);
				break;

			case 6:
				break;

			case 7:
				System.out.println("Exiting");
				break;
			default:
				System.err.println("Invalid choice try again...");
				break;
			}
		} while (choice != 7);

	}

	private static void displayMap(Map<String, Integer> countryMap) {
		// TODO Auto-generated method stub
		for(String country : countryMap.keySet()) {
			System.out.println(country + " : " + countryMap.get(country) );
			
		}
	}

	private static Map<String, Integer> groupByCountry(List<Dog> allDogs) {
Map<String , Integer> countryMap = new TreeMap<String,Integer>();
//tree map to sort alphabetically
for(Dog d : allDogs) {
	int count = 0;
	if(!countryMap.containsKey(d.getCountryOfOrigin())) {
		count=1;
		countryMap.put(d.getCountryOfOrigin(), count);
	}else {
		countryMap.put(d.getCountryOfOrigin(), (countryMap.get(d.getCountryOfOrigin())+1));
	}
}
		
		
		
		return countryMap;
	}

	public static List<Dog> sortedSubListByAttribute(List<Dog> allDogs, int size, String attribute) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		List<Dog> results = new ArrayList<Dog>();
		if(allDogs==null || size<1 || size>allDogs.size() || attribute ==null) {
			throw new IllegalArgumentException("invalid entries");
			
		}else {
			switch (attribute.toLowerCase()) {
			case "height":
				allDogs.sort(new CompareByHeight());
				break;
			case "weight" :
				allDogs.sort(new CompareByWeight());
			default:
				System.out.println("Invalid selection");
				break;
			}
		}
		//create a sublist (up to an including full list) of dogs sorted by relevant attribute
		for(int i =0; i <size; i++) {
			results.add(allDogs.get(i));
			
		}
		Collections.reverse(results);
		return results;
		
	}

	public static void displayAll(List<Dog> printList) {
		// TODO Auto-generated method stub
		if(printList==null) {
			throw new IllegalArgumentException("NULL LIST ");
		}else {
		for(Dog d : printList) {
			d.displayAll();
			System.out.println("\n\n-------------------------------------------");
		
		
		}}
	}

	private static List<Dog> processLines(List<String> allLines) {
		if(allLines==null) {
			throw new IllegalArgumentException("Cannot invoke method with null List");
		}else {
		List<Dog> allDogs = new ArrayList<Dog>();
		String breed,colour,countryOfOrigin;
		double height,weight,expectancy;
		
		for(String line : allLines) {
			try {
				
				String[] parts = line.split(",");
				breed= parts[0].trim();
				weight= Double.parseDouble(parts[1]);
				height= Double.parseDouble(parts[2]);
				expectancy= Double.parseDouble(parts[3]);
				colour = parts[4].trim();
				countryOfOrigin = parts[5].trim();
				
				Dog d = new Dog(breed, colour, countryOfOrigin, weight, height, expectancy);
				allDogs.add(d);
				
			}catch(Exception e) {
				System.err.println(allDogs.size() + "Lines succesfully processed so far.. bad data.. skipping line");
			}
		}
		return allDogs;
		// TODO Auto-generated method stub
		
	}
		}

	public static List<String> readFile(String fileName) {
		// TODO Auto-generated method stub
	
		String line;
		List<String> allLines = new ArrayList<String>();

		try {
			File myFile = new File(fileName);
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			//check for header
			if(line.contains("Breed,Weight (kg),Height (cm),Life expectancy (years),Color,Country of origin")){
				line = br.readLine();
			}
			while(line!=null) {
				allLines.add(line.trim());
				line=br.readLine();
			}

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
