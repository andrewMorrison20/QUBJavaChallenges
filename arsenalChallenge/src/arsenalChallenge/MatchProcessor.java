package arsenalChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MatchProcessor {
public static Map<String , Team> allTeamStats = new HashMap<String,Team>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(readFile().size());
processLines(readFile());
System.out.println(allTeamStats.size());
printleagueTable();

List<Team> teamList = new ArrayList<Team>(allTeamStats.values());
teamList.sort(new CompareByName());
printAll(teamList);


	}

	private static void processLines(List<String> allLines) {
		// TODO Auto-generated method stub
		for(String result : allLines) {
			String[] parts = result.split(" ");
			try {
				int team1pts=0;
				int team2pts=0;
				String team1name = parts[0];
				String team2Name = parts[ parts.length-1];
				int team1Goals = Integer.parseInt( parts[1]);
				int team2Goals = Integer.parseInt(parts[2]);
				
				Team team1 = new Team(team1name);
				Team team2 = new Team(team2Name);
				
				if(team1Goals> team2Goals) {
					team1pts = 3;
					
				}
				if(team1Goals< team2Goals) {
					team2pts = 3;
				}
				if(team1Goals == team2Goals) {
					team1pts=1;
					team2pts=1;
				}
				addTeams(team1,team1pts,team1Goals,team2Goals);
				addTeams(team2,team2pts,team2Goals,team1Goals);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private static  void addTeams(Team team, int teamPts,int goalsFor, int goalsAgainst) {
		// TODO Auto-generated method stub
		 
		if(allTeamStats.containsKey(team.getName())) {
		Team t=	allTeamStats.get(team.getName());
		t.addGoalsAgainst(goalsAgainst);
		t.addGoalsFor (goalsFor);
		switch (teamPts) {
		case 3 :
			t.incrementWins();
			break;
		case 1: 
			t.incrementDraws();
		break;
		case 0:
			t.incrementLosses();
			break;
			
		}
		return;
		
		
		}
		else {
			allTeamStats.put(team.getName(), team);
			addTeams(team,teamPts,goalsFor,goalsAgainst);
		}
	
		}
	

	public static List<String>  readFile() {
		List<String> allLines = new ArrayList<String>();
		// TODO Auto-generated method stub
		try {
			
		File myFile = new File("Results.txt");
		FileReader fr = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine().trim();
		//if (line.contains("Team1 team1 goals team2 goals team2")) {
			//{
				//line = br.readLine();
			//}

			while (line != null) {
				allLines.add(line.trim());
				line = br.readLine();
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
	
	
public static void printleagueTable() {
	
	List<Team> allTeams = new ArrayList<Team>(allTeamStats.values());
	allTeams.sort(new CompareByPoints());
	


	System.out.printf("\n%-15s %-7s %-7s %-7s %-2s %-2s %-10s %s", "Name","Played","For","Against","W","D","L","Total Points");
	for(Team t : allTeams) {
		t.displaySummary();
	}
		}
public static void printAll(List<Team> printList) {
	System.out.println();
	for(Team t : printList) {
		t.allStats();
	}
	
}
}

