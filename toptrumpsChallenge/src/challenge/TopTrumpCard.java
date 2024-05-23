package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TopTrumpCard {
	/**
	 * various constants that define the legal ranges of the attributes;
	 */
	public final int MIN_NAME_LENGTH = 1;
	public final int MAX_NAME_LENGTH = 30;
	public final int MIN_FILENAME_LENGTH = 5;
	public final int MAX_FILENAME_LENGTH = 30;
	public final int MIN_STAT_VALUE = 0;
	public final int MAX_STAT_VALUE = 100;

	/**
	 * name of the current hero card
	 */
	private String name;
	/**
	 * the real name of the actual hero
	 */
	private String realName;
	/**
	 * the file name of the corresponding image for the card - must end in .jpg
	 */
	private String imageFileName;
	/**
	 * the bio of the hero on the current card
	 */
	private String bio;

	/**
	 * category of the current card - either hero or villain
	 */
	private Category category;
	/**
	 * value of thye strength stat for current hero
	 */
	private int strength;
	/**
	 * value of the agility stat for current hero
	 */
	private int agility;
	/**
	 * variable that stores the agility stat of the card
	 */
	private int speed;
	/**
	 * variable that stores the speed stat of the card
	 */
	private int intelligence;

	/**
	 * variable that stores the intelligence stat of the card
	 */

	/**
	 * default constructor - assigns all variables to default
	 */

	public TopTrumpCard() {

	}

	/**
	 * constructor that takes args calls various setters and throws illegal argument
	 * exception if any parameter is outside legal range
	 * 
	 * @param name
	 * @param realName
	 * @param imageFileName
	 * @param bio
	 * @param category
	 * @param strength
	 * @param agility
	 * @param speed
	 * @param intelligence
	 */
	public TopTrumpCard(String name, String realName, String imageFileName, String bio, Category category, int strength,
			int agility, int speed, int intelligence) {

		this.setName(name);
		this.setRealName(realName);
		this.setImageFileName(imageFileName);
		this.setBio(bio);
		this.setCategory(category);
		this.setStrength(strength);
		this.setAgility(agility);
		this.setSpeed(speed);
		this.setIntelligence(intelligence);
	}

	/**
	 * returns the current value of name as a string
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns the value passed to name if within legal range. Throws illegal
	 * argument exception if name length is outisde the pre defined constants
	 * MIN_NAME_LENGTH & MAX_NAME_LENGTH
	 * 
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("INVALID NAME ENTERED MUST BE BETWEEN 1 & 30 CHARACTERS");
		}

		else {
			this.name = name;
		}
	}

	/**
	 * returns the current value of realName as a string
	 * 
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * Assigns the value passed to realName if within legal range. Throws illegal
	 * argument exception if name length is outside the pre-defined constants
	 * MIN_NAME_LENGTH & MAX_NAME_LENGTH
	 * 
	 * @param realName
	 * @throws IllegalArgumentException
	 */

	public void setRealName(String realName) throws IllegalArgumentException {

		if (realName == null || realName.length() < MIN_NAME_LENGTH || realName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("INVALID REAL NAME ENTERED - MUST BE BETWEEN 1 & 30 CHARACTERS");
		}

		else {
			this.realName = realName;
		}
	}

	/**
	 * returns the current value of imageFileName as a string
	 * 
	 * @return imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * Assigns the value passed if within legal range and of correct format. Throws
	 * illegal argument exception if does not end with correct suffix or name length
	 * is outside the pre-defined constants MIN_FILENAME_LENGTH &
	 * MAX_FILENAME_LENGTH
	 * 
	 * @param imageFileName
	 * @throws IllegalArgumentException
	 */

	public void setImageFileName(String imageFileName) throws IllegalArgumentException {
		// COME BACK
		if (!imageFileName.endsWith(".jpg")) {
			throw new IllegalArgumentException("INCORRECT FORMAT - FILE NAME MUST END WITH .JPG");
		} else if (imageFileName.length() < MIN_FILENAME_LENGTH || imageFileName.length() > MAX_FILENAME_LENGTH) {
			throw new IllegalArgumentException("CORRECT FORMAT BUT OUTSIDE LEGAL RANGE");
		} else {
			this.imageFileName = imageFileName;
		}
	}

	/**
	 * returns the current value of bio as a string
	 * 
	 * @return bio
	 */

	public String getBio() {
		return bio;
	}

	/**
	 * Assigns the value passed to BIO if not null. Throws illegal argument
	 * exception if null
	 * 
	 * @param bio
	 * @throws IllegalArgumentException
	 */

	public void setBio(String bio) throws IllegalArgumentException {
		if (bio == null) {
			throw new IllegalArgumentException("BIO CANNOT BE NULL");
		}
		this.bio = bio;
	}

	/**
	 * returns the current value of the enum category
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * sets category to the enum value passed.
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * returns the current value of strength as an int
	 * 
	 * @return Strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Assigns the value passed to strength if within legal range. Throws illegal
	 * argument exception if outside the pre-defined constants MIN_STAT_VALUE &
	 * MAX_STAT_VALUE
	 * 
	 * @param strength
	 * @throws IllegalArgumentException
	 */
	public void setStrength(int strength) throws IllegalArgumentException {
		if (strength < MIN_STAT_VALUE || strength > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("OUTSIDE LEGAL RANGE - MUST BE BETWEEN 0 AND 100 (INCLUSIVE)");
		} else {
			this.strength = strength;
		}
	}

	/**
	 * returns the current value of agility as an int
	 * 
	 * @return agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * Assigns the value passed to agility if within legal range. Throws illegal
	 * argument exception if outside the pre-defined constants MIN_STAT_VALUE &
	 * MAX_STAT_VALUE
	 * 
	 * @param agility
	 * @throws IllegalArgumentException
	 */

	public void setAgility(int agility) throws IllegalArgumentException {
		if (agility < MIN_STAT_VALUE || agility > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("OUTSIDE LEGAL RANGE - MUST BE BETWEEN 0 AND 100 (INCLUSIVE)");
		} else {
			this.agility = agility;
		}
	}

	/**
	 * returns the current value of speed as an int
	 * 
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Assigns the value passed to speed if within legal range. Throws illegal
	 * argument exception if outside the pre-defined constants MIN_STAT_VALUE &
	 * MAX_STAT_VALUE
	 * 
	 * @param speed
	 * @throws IllegalArgumentException
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if (speed < MIN_STAT_VALUE || speed > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("OUTSIDE LEGAL RANGE - MUST BE BETWEEN 0 AND 100 (INCLUSIVE)");
		} else {
			this.speed = speed;
		}
	}

	/**
	 * returns the current value of intelligence as an int
	 * 
	 * @return intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * Assigns the value passed to intelligence if within legal range. Throws
	 * illegal argument exception if outside the pre-defined constants
	 * MIN_STAT_VALUE & MAX_STAT_VALUE
	 * 
	 * @param intelligence
	 * @throws IllegalArgumentException
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if (intelligence < MIN_STAT_VALUE || intelligence > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("OUTSIDE LEGAL RANGE - MUST BE BETWEEN 0 AND 100 (INCLUSIVE)");
		} else {
			this.intelligence = intelligence;
		}
	}

	/**
	 * calculates the max stat value of all stats, if two stats are equal chooses the stat which appears first within the map of stats. returns 0,1,2,3 depending on if 
	 * the max stat is speed strength agility or intelligence respectively.
	 * @return int
	 */
	public int getMaxStatID() {

		String statId=null;
		int maxStat;
		//tree map to store stats -uses natural ordering so will be alphabetical i.e agility,intelligence,speed,strength;
		
		Map<String,Integer> statsMap = new TreeMap<String,Integer>();
		
		statsMap.put("strength", strength);
		statsMap.put("speed", speed);
		statsMap.put("agility", agility);
		statsMap.put("intelligence", intelligence);
		
		maxStat = Collections .max(statsMap.values());	
		
		for(String stat : statsMap.keySet()) {
			if (statsMap.get(stat)== maxStat) {
				statId = stat;
				//break so take first occurence if mutiple matches
				break;}
			}
		
	
		
		switch(statId) {
		case "speed":
			return 0 ;
		case "strength":
			return 1;
		case "agility": 
			return 2;
		case "intelligence":
			return 3;
		default :
			throw new IllegalArgumentException("Invalid input");
		
		}
		}
	
	/**
	 * takes an int as an argument and returns the corresponding value of the max stat;
	 * @param statChoice
	 * @return
	 */
	
	public int getStatScore(int statChoice)	{
		switch(statChoice) {
		case 0:
			return speed;
		case 1:
			return strength;
		case 2 :
			return agility;
		case 3 : 
			return intelligence;
		default:
			throw new IllegalArgumentException("INVALID INPUT");
		}
		
	}
	
	public void displayAll() {
		System.out.println();
		System.out.printf("%-20s : %s","Name", name);
		System.out.printf("\n%-20s : %s","Real Name", realName);
		System.out.printf("\n%-20s : %s","File Name", imageFileName);
		System.out.printf("\n%-20s : %s","Category", category);
		System.out.printf("\n%-20s : %d","Speed", speed);
		System.out.printf("\n%-20s : %d","Strength", strength);
		System.out.printf("\n%-20s : %d","Agility", agility);
		System.out.printf("\n%-20s : %d","Intelligence", intelligence);
		System.out.printf("\n%-20s : %s","Bio", bio);
		System.out.println();
	}

	@Override
	public int hashCode() {
		return Objects.hash(agility, bio, category, imageFileName, intelligence, name, realName, speed, strength);
	}
	
	public double getAverage() {
		return ((double)((strength+speed+intelligence+agility)))/4.00;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		return agility == other.agility && Objects.equals(bio, other.bio) && category == other.category
				&& Objects.equals(imageFileName, other.imageFileName) && intelligence == other.intelligence
				&& Objects.equals(name, other.name) && Objects.equals(realName, other.realName) && speed == other.speed
				&& strength == other.strength;
	}
}

