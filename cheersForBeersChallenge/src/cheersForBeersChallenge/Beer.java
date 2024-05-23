package cheersForBeersChallenge;

public class Beer {
	public static final int MIN_LENGTH_NAME= 3;
	public static final int MAX_LENGTH_NAME =50;
	public static final int MIN_LENGTH_COUNTRY= 3;
	public static final int MAX_LENGTH_COUNTRY =50;
	public static final int MIN_LENGTH_STYLE =  3;
	public static final int MAX_LENGTH_STYLE =50;
	
	public static final double MIN_PERCENTAGE= 0.00;
	public static final double MAX_PERCENTAGE =15.00;
	
	
	
private String name;
private String country;
private String style;
private double percentage;

public Beer() {
	
}


public Beer(String name, String style, String country, double percentage) {
	this.setCountry(country);
	this.setName(name);
	this.setPercentage(percentage);
	this.setStyle(style);
	
	
}
public String getName(){
	return name;
}
public void setName(String name) throws IllegalArgumentException{
	if(name==null) {
		throw new IllegalArgumentException("Name cannot be null");
	}

else if(name.length() < MIN_LENGTH_NAME || name.length()> MAX_LENGTH_NAME) {
		throw new IllegalArgumentException("NAME LENGTH OUTSIDE LEGAL RANGE" + name);
	}
	
	else {	this.name = name;}
}
public String getCountry() {
	return country;
}
public void setCountry(String country) throws IllegalArgumentException{

	if(country==null) {
		throw new IllegalArgumentException("Name cannot be null");
	}

else if(country.length() < MIN_LENGTH_COUNTRY || country.length()> MAX_LENGTH_COUNTRY) {
		throw new IllegalArgumentException("COUNTRY LENGTH OUTSIDE LEGAL RANGE");
	}
	
else{this.country = country;}
}
public String getStyle() {
	return style;
}
public void setStyle(String style)throws IllegalArgumentException {
	if(style==null) {
		throw new IllegalArgumentException("STYLE cannot be null");
	}

else if(style.length() < MIN_LENGTH_STYLE || style.length()> MAX_LENGTH_STYLE) {
		throw new IllegalArgumentException("STYLE LENGTH OUTSIDE LEGAL RANGE");
	}
	
	else{this.style = style;}
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage)throws IllegalArgumentException {

	if(percentage < MIN_PERCENTAGE|| percentage> MAX_PERCENTAGE) {
		throw new IllegalArgumentException("PERCENTAGE LENGTH OUTSIDE LEGAL RANGE");
	}
	else{this.percentage = percentage;}
}

public void displayAll () {
	System.out.println();
	
	System.out.printf("%-5s %-10s \n%-5s %-10s \n%-5s %-10s \n%-5s  %.2f %% \n", "Beer Name : ",name, "Beer Style : ",style, "Beer Country : ",country,"Percentage Alcohol : ",percentage);
	System.out.println();
}
}
