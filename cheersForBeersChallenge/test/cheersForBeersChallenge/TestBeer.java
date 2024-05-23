package cheersForBeersChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBeer {
	//reusing test data for various strings as all business rules same
	String validNameMin, validNameMid,validNameMax, invalidNameMin, invalidNameMax;
	double validPercentageMin, validPercentageMid, validPercentageMax, invalidPercentageMin, invalidPercentageMax;
	Beer beer;
	

	@BeforeEach
	void setUp() throws Exception {
		
	validNameMin = "a".repeat(3) ;
	validNameMid = "validName";
	validNameMax = "a".repeat(21);
	invalidNameMin= "x".repeat(2); 
	invalidNameMax= "x".repeat(21);
	validPercentageMin= 0.00; ; 
	validPercentageMid = 7.50;
	validPercentageMax = 15.00;; 
	invalidPercentageMin= -0.01; 
	invalidPercentageMax= 15.01;
	beer= new Beer();
	}

	@Test
	void testConstructorValidArgs() {
		beer = new Beer(validNameMin, validNameMin, validNameMin, validPercentageMin);
		assertEquals(validNameMin, beer.getName());
		assertEquals(validNameMin, beer.getStyle());
		assertEquals(validNameMin, beer.getCountry());
		assertEquals(validPercentageMin, beer.getPercentage(),0.01);
		}
	

	@Test
	void testConstructorInvalidArgsExpectsException() {

		assertThrows(IllegalArgumentException.class, () -> {

			beer = new Beer(invalidNameMin, validNameMin, validNameMin, validPercentageMin);

		});

		assertThrows(IllegalArgumentException.class, () -> {

			beer = new Beer(validNameMin, invalidNameMin, validNameMin, validPercentageMin);

		});

		assertThrows(IllegalArgumentException.class, () -> {

			beer = new Beer(validNameMin, validNameMin, invalidNameMin, validPercentageMin);

		});

		assertThrows(IllegalArgumentException.class, () -> {

			beer = new Beer(validNameMin, validNameMin, validNameMin, invalidPercentageMin);

		});
	}
		

	@Test
	void testgetSetValidName() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSetInvalidNameExpectsException() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSetValidCountry() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSetInvalidCountryExpectsException() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetSetValidStyle() {
		fail("Not yet implemented");
	}
	@Test
	void testSetInvalidStyleExpectsException() {
		fail("Not yet implemented");
	}

	@Test
	void testSetValidpercentage() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSetInvalidPercentageExpectsException() {
		fail("Not yet implemented");
	}

}
