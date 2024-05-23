package countriesOfTheWorldchallenge;

public class Country {
	
	
private double density;
private String country;
private String region;
private double population;
private double area;

public Country(String country,String region, double population, double area) {
	this.setCountry(country);
	this.setRegion(region);
	this.setArea(area);
	this.setPopulation(population);
	this.calcDensity();
	
}

public double getDensity() {
	return density;
}
public void calcDensity() throws IllegalArgumentException {
	if(area > 0) {
	this.density = population/area;}
	else {throw new IllegalArgumentException("Area cannot be non positive.");}
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public double getPopulation() {
	return population;
}
public void setPopulation(double population) {
	this.population = population;
	this.calcDensity();
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
	this.calcDensity();
}
@Override
public String toString() {
	return "Country [density=" + density + ", Country=" + country + ", Region=" + region + ", Population=" + population
			+ ", Area=" + area + "]";
}


}
