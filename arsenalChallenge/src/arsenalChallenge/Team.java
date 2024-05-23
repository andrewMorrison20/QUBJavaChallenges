package arsenalChallenge;

import java.util.Objects;

public class Team {
private String name;
private int wins=0;
private int losses=0;
private int draws=0;
private int goalsFor = 0;
private int goalsAgainst=0 ;


public Team(String name) {
	this.setTeamName(name);
	

}

public String getName() {
	return name;
}
public void addGoalsFor(int goalsFor) {
	// TODO Auto-generated method stub
	this.goalsFor+= goalsFor;
}

public void addGoalsAgainst(int goalsAgainst) {
	// TODO Auto-generated method stub
	this.goalsAgainst+= goalsAgainst;
}

public int getGoalsFor() {
	return goalsFor;
}

public int getGoalsAgainst() {
	return goalsAgainst;
}


@Override
public int hashCode() {
	return Objects.hash(name);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Team other = (Team) obj;
	return Objects.equals(name, other.name);
}

public void setTeamName(String name) {
	this.name= name;
}
public void incrementWins() {
	this.wins++;
}
public void incrementLosses() {
		this.losses++;
		
	}
public void incrementDraws() {
	this.draws++;
	
}

public int calcTotalPoints() {
	return (this.getWins()*3 + this.getDraws());
}

private int getDraws() {
	// TODO Auto-generated method stub
	return draws;
}

private int getWins() {
	// TODO Auto-generated method stub
	return wins;
}
public int getLosses() {
	return losses;
}




public void allStats() {
	System.out.println();
	System.out.println(name);
	System.out.println("Games Played  : "+ calcplayed());
	System.out.println("Goals for     : "+ goalsFor);
    System.out.println("Goals against : "+ goalsAgainst);
    System.out.println("Wins          : "+ wins);
    System.out.println("Draws         : " + draws);
    System.out.println("Losses        : " + losses);
    System.out.println("Points        : "+ calcTotalPoints());
    System.out.println();
}

public void displaySummary() {
	System.out.printf("\n%-15s %-7d %-7d %-7d %-2d %-2d %-10d %d", name,calcplayed(),goalsFor,goalsAgainst,wins,draws,losses,calcTotalPoints());

}

private int calcplayed() {
	// TODO Auto-generated method stub
	return getWins()+getLosses()+getDraws();
}
}

