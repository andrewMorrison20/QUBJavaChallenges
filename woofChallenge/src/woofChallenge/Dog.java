package woofChallenge;

public class Dog {

	/**
	 * various variables relating to the different attributes of the current dog
	 */
	private String breed;
	private String colour;
	private String countryOfOrigin;
	private double weight;
	private double height;
	private double expectancy;

	/**
	 * default constructor takes no args
	 */

	public Dog() {

	}

	/**
	 * constructor that takes args, calls relevant setter for each variable with
	 * passed parameter.
	 * 
	 * @param breed
	 * @param colour
	 * @param countryOfOrigin
	 * @param weight
	 * @param height
	 * @param expectancy
	 */
	public Dog(String breed, String colour, String countryOfOrigin, double weight, double height, double expectancy) {

		this.setBreed(breed);
		this.setColour(colour);
		this.setCountryOfOrigin(countryOfOrigin);
		this.setWeight(weight);
		this.setHeight(height);
		this.setExpectancy(expectancy);
	}

	/**
	 * returns the breed of the dog as a string
	 * 
	 * @return breed
	 */

	public String getBreed() {
		return breed;
	}

	/**
	 * assigns the variable breed with the argument passed if not null - else throws
	 * an illegal Argument exception
	 * 
	 * @param breed
	 */
	public void setBreed(String breed) throws IllegalArgumentException {
		if (breed == null) {
			throw new IllegalArgumentException("Cannot be null");
		} else {
			this.breed = breed;
		}
	}

	/**
	 * returns the current value of colour as a string
	 * 
	 * @return
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the variable colour with the value passed if not null - else throws an
	 * illegal Argument exception
	 * 
	 * @param colour
	 */
	public void setColour(String colour) throws IllegalArgumentException {
		if (colour == null) {
			throw new IllegalArgumentException("Cannot be null");
		}
		this.colour = colour;
	}

	/**
	 * returns the value of country of origin as a string
	 * 
	 * @return countryOfOrigin
	 */
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	/**
	 * assigns the variable countryOfOrigin to the passed value if not null - else
	 * throws an illegal Argument exception
	 * 
	 * @param countryOfOrigin
	 */
	public void setCountryOfOrigin(String countryOfOrigin) throws IllegalArgumentException {
		if (countryOfOrigin == null) {
			throw new IllegalArgumentException("Cannot be null");
		} else {
			this.countryOfOrigin = countryOfOrigin;
		}
	}

	/**
	 * returns the current value of the variable weight as a double if greater than
	 * zero - else throws an illegal Argument exception
	 * 
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * sets the weight to the value passed if greater than zero - else throws an
	 * illegal Argument exception
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) throws IllegalArgumentException {
		if (weight <= 0) {
			throw new IllegalArgumentException("outside Legal Range");
		}

		else {
			this.weight = weight;
		}
	}

	/**
	 * returns the current value of the variable weight;
	 * 
	 * @return weight
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * sets the variable height to the value passed if greater than zero - else
	 * throws an illegal Argument exception
	 * 
	 * @param height
	 */
	public void setHeight(double height) throws IllegalArgumentException {
		if (height <= 0) {
			throw new IllegalArgumentException("outside Legal Range");
		} else {
			this.height = height;
		}
	}

	/**
	 * returns the current value of life expectancy as a double
	 * 
	 * @return expectancy
	 */
	public double getExpectancy() {
		return expectancy;
	}

	/**
	 * assigns the variable expectancy with the argument passed if greater than zero
	 * - else throws an illegal Argument exception
	 * 
	 * @param expectancy
	 */
	public void setExpectancy(double expectancy) throws IllegalArgumentException {
		if (expectancy <= 0) {
			throw new IllegalArgumentException("Cannot not be zero or negative");
		} else {
			this.expectancy = expectancy;
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Breed  : ");
		str.append(breed);
		str.append(" | ");
		str.append("Origin : ");
		str.append(countryOfOrigin);
		str.append(" | ");
		str.append("Colour : ");
		str.append(colour);
		str.append(" | ");
		str.append("Height : ");
		str.append(height);
		str.append("cm");
		str.append(" | ");
		str.append("Weight : ");
		str.append(weight);
		str.append("Kg");
		str.append(" | ");
		str.append("Life Expectancy : ");
		str.append(expectancy);
		str.append(" yrs ");
		str.append(" | ");
		
		return str.toString();
	}

	public void displayAll() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s : %s", "Breed",breed);
		System.out.printf("\n%-20s : %s", "Origin",countryOfOrigin);
		System.out.printf("\n%-20s : %s", "Colour",colour);
		System.out.printf("\n%-20s : %.1f", "Height",height);
		System.out.printf("\n%-20s : %.1f", "Weight",weight);
		System.out.printf("\n%-20s : %.1f", "Life Expectancy",expectancy);
		
		
	}

}
