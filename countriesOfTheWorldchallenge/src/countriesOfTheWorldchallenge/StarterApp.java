package countriesOfTheWorldchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StarterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String> ();
		
		
		Map<String, Country> countryMap = new HashMap<String,Country>();
readfile(lines);
System.out.println(lines);
processLines(lines, countryMap);
displayAllCountriesByPopulation(countryMap);
//List<Country> results= searchByRegion(countryMap,"Europe");
displayByRegion(countryMap);
	}

	public static void displayByRegion(Map<String, Country> countryMap) {
		// TODO Auto-generated method stub
		String[] regions = {
				"Africa", "Asia","Baltics","Europe","LATIN AMER. & CARIB","OCEANIA","NEAR EAST","NORTHERN AMERICA"
		};
		System.out.printf("%-35s %-35s", "REGION", "COUNTRY");
		for(String string : regions) {
		List<Country> results = searchByRegion(countryMap,string);
		
		for(Country c : results) {
			System.out.printf("\n%-35s %-35s", c.getRegion(),c.getCountry());
		}
		}
		
	}

	public static List<Country> searchByRegion(Map<String, Country> countryMap, String region) {
		//could potentially use an enum here to eliminate negative path might be convoluted - come back
		List<Country> results= new ArrayList<Country>();
		String currentRegion = " ";
		if(countryMap ==null|| region ==null) {
			throw new IllegalArgumentException("Invalid entry!");
		}else {
		List<Country> countryList = new LinkedList<Country>(countryMap.values());
		for(Country c : countryList) {
		 currentRegion = c.getRegion();
		 currentRegion = currentRegion.toLowerCase();
		 if(currentRegion.contains(region.toLowerCase())) {
			 results.add(c);
		 }
		}
		}
		return results;
	}

	public static void displayAllCountriesByPopulation(Map<String, Country> countryMap) {
		// TODO Auto-generated method stub
		List<Country> countryList = new LinkedList<Country>(countryMap.values());
		countryList.sort(new CompareByPopulation());
		System.out.println("Countries by ascending population");
		System.out.println();
		for (Country c : countryList) {
			System.out.printf("\n%-10.0f %-10s", c.getPopulation(), c.getCountry());
		}
	}

	public static void displayAllCountries(Map<String, Country> countryMap) {
		// TODO Auto-generated method stub
		
		
	}

	public static void processLines(List<String> lines, Map<String,Country> countryMap) {
		// TODO Auto-generated method stub
		for (String string : lines) {
			String [] tokenisedLines = string.split(",");
			 String country = tokenisedLines[0];
			 String region =  tokenisedLines[1];
			 double population =  Integer.parseInt(tokenisedLines [2]);
			 double area =Integer.parseInt( tokenisedLines[3]);
			 
			 addToMap(countryMap,country,region,population,area);
		}
	}

	public static void addToMap(Map<String, Country> countryMap, String country, String region, double population,
			double area) {
		// TODO Auto-generated method stub
		if (countryMap.containsKey(country)) {
			// edit the europe / africa issue here
			Country c = countryMap.get(country);
			String countryRegion = c.getRegion();
			if (countryRegion.contains("EASTERN EUROPE") || countryRegion.contains("WESTERN EUROPE")) {
				c.setRegion("Europe");}
				if (countryRegion.contains("SUB-SAHARAN AFRICA") || countryRegion.contains("NORTHERN AFRICA")) {
					c.setRegion("Africa");
				}
			
		}else { 
			countryMap.put(country, new Country(country,region,population,area));
			addToMap(countryMap, country, region, population, area);
			
		}
			
	}

	public static void readfile(List<String> lines) {
		// TODO Auto-generated method stub
		
		try {
			File myFile = new File("countries.csv");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = br.readLine();
			//check for header data
			if(currentLine.contains("Country,Region,Population,Area (sq. mi.)")) {
				//discard header
				currentLine = br.readLine();
			}
			while (currentLine != null) {
			
				lines.add(currentLine);
				currentLine= br.readLine();
				
			}fr.close();
			br.close();
			
;		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
