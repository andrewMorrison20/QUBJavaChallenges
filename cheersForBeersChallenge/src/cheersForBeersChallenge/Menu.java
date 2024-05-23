package cheersForBeersChallenge;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		displayMenu();
		
		

	}

	public static void displayMenu() {
		// TODO Auto-generated method stub
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Starting Menu....");
		List<Beer> allBeers = readFile();
		do {
			
			try {
				Thread.sleep(2000);
				
			System.out.println("Please select an option: ");
			Thread.sleep(1000);
			System.out.println("1) Show All Beers");
			Thread.sleep(1000);
			System.out.println("2) Order By Name");
			Thread.sleep(1000);
			System.out.println("3) Output to file all beers over 6% alcohol");
			Thread.sleep(1000);
			System.out.println("4) Quit");
			
			choice= sc.nextInt();
			
			switch(choice) {
			case 1:
				showAllBeers(allBeers);
				break;
			case 2:
				
				orderByName(allBeers);
				
				
				break;
			case 3:
				CallWriterThread(allBeers);
				break;
			case 4:
				System.out.println("Exiting menu..");
				break;
			}
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	while(choice !=4);	
	}

	public static void CallWriterThread(List<Beer> allBeers) {
		String percentage;
		// TODO Auto-generated method stub
		WriterThread myWriter = new WriterThread(allBeers,6.00);
		Thread t = new Thread(myWriter);
		t.start();
	}

	public static List<Beer> searchAndSortByAttribute(List<Beer> allBeers, String attribute,int size) {
		// TODO Auto-generated method stub
		List<Beer> copyMenu = new ArrayList<>(allBeers);
	    String	searchKey = attribute.toLowerCase();
		List<Beer> results = new ArrayList<Beer>();
		if(allBeers ==null || attribute ==null) {
			System.err.println("Null entry! check parameters");
		}
		else {
		switch (searchKey) {
		case "name" :
			copyMenu.sort(new CompareByName());
			break;
		case "style" :
			//copyMenu.sort(new CompareByStyle());
			
			break;
		case "percentage" :
			copyMenu.sort(new CompareByPercentage());
			break;
		case "country" :
			//copyMenu.sort(new CompareByCountry());
			break;
		default :
			System.err.println("Attribute not found");
			break;
		}}
		for(int i =0; i < size;i++) {
			results.add(copyMenu.get(i));}
		
		return results;
	}

	public static void orderByName(List<Beer> allBeers) {
		// TODO Auto-generated method stub
		allBeers.sort(new CompareByName());
		
	}

	public static void showAllBeers(List<Beer> allBeers) {
		int count =1;

		for (Beer beer : allBeers) {
			System.out.println(count + ")");
			beer.displayAll();
			count++;
		}
	}
	
	public static void subList(List<Beer> list, double upper, double lower) {
		List<Beer> temp = new ArrayList<Beer>();
		if(upper<lower) {throw new IllegalArgumentException("Check ranges");}
		else {
			for(Beer beer :list) {
		if(beer.getPercentage()>=lower&& beer.getPercentage()<=upper) {
			temp.add(beer);
		}}
			list.clear();
			list.addAll(temp);
	}}

	public static List<Beer> readFile() {
		String name, country, style;
		double percentage;
		List<Beer> allBeers = new ArrayList<Beer>();
		try {	
			
			File myFile = new File("beer_data.csv");
			FileReader fr= new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line.contains("Beer Name,Beer Style,Country,Alcohol Percentage")) {
				line = br.readLine();
			}
			while (line != null) {
				try {
					String[] splits = line.split(",");
					name = splits[0];
					style = splits[1];
					country = splits[2];
					percentage = Double.parseDouble(splits[3]);

					Beer beer = new Beer(name, style, country, percentage);
					allBeers.add(beer);

					line = br.readLine();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Something went wrong ! BAD DATA");
				}
				
			}//br.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allBeers;
	}

}
