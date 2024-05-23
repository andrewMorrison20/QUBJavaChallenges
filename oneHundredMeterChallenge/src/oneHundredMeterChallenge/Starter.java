package oneHundredMeterChallenge;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Starter {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map<String, Double> race = new TreeMap<String,Double>();
processResults(race,readFile("runners.csv"));

System.out.println("ON YOUR MARKS");
try {
	Thread.currentThread().sleep(2000);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
System.out.println("GET SET");
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Bang!");
System.out.println("Race Started");

for(String name : race.keySet()) {
	
RaceTimer raceTimer = new RaceTimer(race.get(name),name); 
Thread t = new Thread(raceTimer);
t.start();
}
	}

	public static void processResults(Map<String , Double> race ,List<String> allLines) {
		for(String line : allLines) {
			try {
				String [] parts = line.split(",");
				race.put(parts[0],Double.parseDouble(parts[1]));
				
			}catch(Exception e ) {
				
			}
		}
	}

	public static List<String> readFile( String fileName) {
		// TODO Auto-generated method stub
		List<String> allLines = new ArrayList<String>();
		
		try {
			File myFile = new File(fileName);
		    FileReader fr;
			fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
		    String line= br.readLine();
		    if(line.contains("Runner,Time")) {
			//discard
			line=br.readLine();
		}
		while(line!=null) {
			allLines.add(line);
			line=br.readLine();
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
		
		//check for header 
	
		return allLines;
	}

}
