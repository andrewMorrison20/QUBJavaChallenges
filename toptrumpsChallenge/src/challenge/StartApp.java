package challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class StartApp {
	
	/**
	 * Entry point of program 
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();	
	}
	
	/**
	 * Launches menu system which in turn calls appropriate methods based on user choices
	 */
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println();
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				System.out.println(mainDeck.size());
				break;
			case 2:
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				displayDeckSize(mainDeck);
				break;
			case 4:
				System.out.println("Displaying all cards in the current deck");
				displayAll(mainDeck);
				break;
			case 5:
				showSummary(orderedSublistByAttribute(searchByCategory(mainDeck,Category.HERO),5,"strength"));
				break;
			case 6:
				//get all villains
				List<TopTrumpCard> allVillains = searchByCategory(mainDeck, Category.VILLAIN);
				//order deck of all villains by name (alphabeticaly)
				orderedSublistByAttribute(allVillains, allVillains.size(), "name");
				//find cards with agility>75 in list;
				showSummary(findCardsInRange(	orderedSublistByAttribute(allVillains, allVillains.size(), "name"),75,100));
				break;
			case 7:
				//get card and therefore length of longest bio
				displayAll(getLongestBioList(mainDeck));
				break;
			case 8:
				//spec unclear as to wether list of duplicates should include orginal or just dup i.e n-1 count of each card - provided both
				System.out.println("Displaying list of duplicate cards including all instances of card");
				showSummary(DuplicateList(mainDeck));
				System.out.println("Displaying list of duplicate cards including only additional instances of card");
				List<TopTrumpCard> onlyExtras = new ArrayList<TopTrumpCard>();
				onlyExtras= DuplicateList(mainDeck);
				removeDuplicates(onlyExtras);
				showSummary(onlyExtras);
				break;
			case 9:
				removeDuplicates(mainDeck);
				break;
			case 10:
				List<TopTrumpCard> printList = (orderedSublistByAttribute(mainDeck, mainDeck.size(), "average"));
				Collections.reverse(printList);
				showSummary(printList);
				break;
			case 11:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}

	private static List<TopTrumpCard> DuplicateList(List<TopTrumpCard> mainDeck) {
		List<TopTrumpCard> results= new ArrayList<TopTrumpCard>();
		// TODO Auto-generated method stub
		for(TopTrumpCard t : mainDeck) {
			if(Collections.frequency(mainDeck, t)>1) {
				results.add(t);
			}
		}
		return results;
	}

	public static void removeDuplicates(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		Set<TopTrumpCard> noDups = new LinkedHashSet<TopTrumpCard>(mainDeck);
		mainDeck.clear();
		mainDeck.addAll(noDups);
	}

	private static List<TopTrumpCard> getLongestBioList(List<TopTrumpCard> searchList ) {
		// TODO Auto-generated method stub
		List<TopTrumpCard>results= new ArrayList<TopTrumpCard>();
		//get card and therefore length of longest bio
		TopTrumpCard card = orderedSublistByAttribute(searchList, 1, "bio").get(0);
		//check for cards that have this length of bio and add to results list
		for(TopTrumpCard t : searchList) {
			if(t.getBio().length() == card.getBio().length()) {
				results.add(t);
			}
		}
		return results;
	}

	public static List<TopTrumpCard> findCardsInRange(List<TopTrumpCard> mainDeck, int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		
		if(mainDeck==null|| lowerBound>upperBound) {
			throw new IllegalArgumentException("INVALID SEARCH CRITERIA");
		}else {
			for(TopTrumpCard c : mainDeck) {
				if(c.getAgility()>=lowerBound && c.getAgility()<=upperBound) {
					results.add(c);
				}
				
			}
		}
		return results;
	}

	public static List<TopTrumpCard> orderedSublistByAttribute(List<TopTrumpCard> mainDeck, int size, String stat) {

		List<TopTrumpCard> orderedList = new ArrayList<TopTrumpCard>();
		List<TopTrumpCard> copy = new ArrayList<TopTrumpCard>(mainDeck);

		if (mainDeck == null || size > mainDeck.size() || stat == null) {
			throw new IllegalArgumentException("INVALID SEARCH CRITERIA");
		} else {
			switch (stat.toLowerCase()) {
			// first sort copy of deck by desired attribute
			case "name" :
				copy.sort(new CompareByName());
				break;
			case "strength":
				copy.sort(new CompareByStrength());
				break;
			case "speed":
				copy.sort(new CompareBySpeed());
				break;
			case "agility":
				copy.sort(new CompareByAgility());
				break;
			case "intelligence":
				copy.sort(new CompareByIntelligence());
				break;
			case "bio":
				copy.sort(new CompareByBio());
				break;
			case "average":
				copy.sort(new CompareByAverage());
				break;
			default:
				System.err.println("Invalid stat type selected");
			}
			// next create ordered sublist of desired size by adding cards sequentially to
			// results list

			for (int i = 0; i < size; i++) {
				orderedList.add(copy.get(i));
			}
		}

		return orderedList;

	}

	public static List<TopTrumpCard> searchByCategory(List<TopTrumpCard> mainDeck, Category category) {
		// TODO Auto-generated method stub
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		if(mainDeck==null || category ==null) {
			throw new IllegalArgumentException("Cannot have null entries");
		}else {
			for(TopTrumpCard card: mainDeck) {
				if(card.getCategory().equals(category)) {
					results.add(card);
				}
			}
		}
		return results;
	}

	public static void showSummary(List<TopTrumpCard> deck) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		if(deck==null) {
			throw new IllegalArgumentException("Cannot print details for null deck- must contain at least 1 card");
		}else {
		int count = 1;
		for (TopTrumpCard card : deck) {
			System.out.println("\n" + count + ")");
			System.out.printf("%s / %s (%s)", card.getName(), card.getRealName(), card.getCategory());
			System.out.printf("\n%-3s : %d |%-3s : %d |%-3s : %d |%-3s : %d |", "sp", card.getSpeed(), "st",
					card.getStrength(), "ag", card.getAgility(), "in", card.getIntelligence());
			System.out.println("Average : "+card.getAverage());
			System.out.println();
			count++;
		}}
	}

	public static void displayAll(List<TopTrumpCard> mainDeck) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (mainDeck == null) {
			throw new IllegalArgumentException("Cannot print details for null deck- must contain at least 1 card");
		} else {
			
			for (int i = 0; i < 8; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf(".");
			}
			for (TopTrumpCard card : mainDeck) {
				card.displayAll();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void displayDeckSize(Collection<TopTrumpCard> mainDeck) {
		System.out.println(mainDeck.size() + " Cards in the current deck\n");
		
	}

	
	public static List<TopTrumpCard> readData() {

		List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();

		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {
				try {
			String [] parts = line.split(",");
			String name = parts[0];
			String realName = parts[1];
			String imageFileName = parts[2];
			Category category = Category.valueOf(parts[3].toUpperCase());
			int speed = Integer.parseInt(parts[4]);
			int strength =  Integer.parseInt(parts[5]);
			int agility= Integer.parseInt(parts[6]);
		    int intelligence = Integer.parseInt(parts[7]);
			String bio=  parts[8];
			
			TopTrumpCard card = new TopTrumpCard(name, realName, imageFileName, bio, category, strength, agility, speed, intelligence);
			listFromFile.add(card);
			
			line = reader.readLine();
			
			
				}catch (Exception e) {
					e.printStackTrace();
					
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}

}
