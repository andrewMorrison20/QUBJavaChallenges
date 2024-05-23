package woofChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDog {

String validBreed,validOrigin,validColour;
String invalidBreed,invalidOrigin,invalidColour;
double validHeight, validWeight, validExpectancy;
double invalidHeight, invalidWeight, invalidExpectancy;
Dog dog;	
	
@BeforeEach
void setUp() throws Exception{
	
	validBreed = "a";
	validOrigin = "b";
	validColour= "c";
	invalidBreed = null;
	invalidOrigin= null;
	invalidColour= null;
	validHeight= 0.1;
	validWeight = 0.1;
	validExpectancy= 0.1;
	invalidHeight = 0;
	invalidWeight=0;
	invalidExpectancy= 0;
	dog = new Dog();
}
	@Test
	void testDogDefault() {
	assertNotNull(dog);
	}

	@Test
	void testConstructorWithArgsValid() {
		dog = new Dog(validBreed, validColour, validOrigin, validWeight, validHeight, validExpectancy);
		assertEquals(validBreed, dog.getBreed());
		assertEquals(validColour, dog.getColour());
		assertEquals(validOrigin,dog.getCountryOfOrigin());
		assertEquals(validWeight, dog.getWeight(),0.1);
		assertEquals(validHeight, dog.getHeight());	
		assertEquals(validExpectancy, dog.getExpectancy());}
	
	
	@Test
	void testConstructorWithInvalidArgsExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(invalidBreed, validColour, validOrigin, validWeight, validHeight, validExpectancy);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(validBreed, invalidColour, validOrigin, validWeight, validHeight, validExpectancy);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(validBreed, validColour, invalidOrigin, validWeight, validHeight, validExpectancy);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(validBreed, validColour, validOrigin, invalidWeight, validHeight, validExpectancy);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(validBreed, validColour, validOrigin, validWeight, invalidHeight, validExpectancy);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			dog = new Dog(validBreed, validColour, validOrigin, validWeight, validHeight, invalidExpectancy);
		});
	}

	@Test
	void testGetSetBreedValidArgs() {
		String expected,actual;
		expected= validBreed;
		dog.setBreed(validBreed);
		actual = dog.getBreed();
		assertEquals(expected, actual);
	}

	
	@Test
	void testSetInvalidBreedExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			dog.setBreed(invalidBreed);
		});
	}
	@Test
	void testGetSetColourValid() {
		String expected,actual;
		expected= validColour;
		dog.setColour(validColour);
		actual = dog.getColour();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetInvalidColourExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			dog.setColour(invalidColour);
		});
	}

	@Test
	void testGetSetCountryOfOriginValid() {
		String expected,actual;
		expected= validOrigin;
		dog.setCountryOfOrigin(validOrigin);
		actual = dog.getCountryOfOrigin();
		assertEquals(expected, actual);
	}
	@Test
	void testSetInvalidOriginExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			dog.setCountryOfOrigin(invalidOrigin);
		});
	}
	@Test
	void testGetSetWeightValid() {
		double actual,expected;
		expected = validWeight;
		dog.setWeight(expected);
		actual = dog.getWeight();
		assertEquals(expected, actual,0.1);
	}
	
	@Test
	void testSetInvalidWeightExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			dog.setWeight(invalidWeight);
			
		});
		
		
	}

	@Test
	void testGetSetHeightValid() {
		double actual,expected;
		expected = validHeight;
		dog.setHeight(expected);
		actual = dog.getHeight();
		assertEquals(expected, actual,0.1);
	}
	@Test
	void testSetInvalidHeightExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			dog.setHeight(invalidHeight);
			
		});
	}
	@Test
	void testSetExpectancy() {


		double actual, expected;
		expected = validExpectancy;
		dog.setExpectancy(expected);
		actual = dog.getExpectancy();
		assertEquals(expected, actual,0.1);
	}
	
	@Test
	void testSetInvalidExpectancyExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			dog.setExpectancy(invalidExpectancy);
			
		});
	
}}
