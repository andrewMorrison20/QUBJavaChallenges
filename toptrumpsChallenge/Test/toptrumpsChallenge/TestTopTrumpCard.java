package toptrumpsChallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenge.Category;
import challenge.TopTrumpCard;

class TestTopTrumpCard {
String validNameMin,validNameMid,validNameMax,invalidNameMin,invalidNameMax;
String validRealNameMin,validRealNameMid,validRealNameMax,invalidRealNameMin,invalidRealNameMax;
String validFileNameMin,validFileNameMid,validFileNameMax, invalidFileNameJpgMin, invalidFileNameJpgMax, 
invalidFileNameNoJpgMin, invalidFileNameNoJpgMax;
int validStatValueMin, validStatValueMid,validStatValueMax,invalidStatValueMin,invalidStatValueMax;
String validBioZero, validBio, invalidBio;
TopTrumpCard card;
	@BeforeEach
	void setUp() throws Exception {
		validNameMin ="a";
		validNameMid = "ValidName";
		validNameMax= "a".repeat(30);
		invalidNameMin = "";
		invalidNameMax = "x".repeat(31);
		validRealNameMin ="a";
		validRealNameMid = "ValidRealName";
		validRealNameMax= "a".repeat(30);
		invalidRealNameMin = "";
		invalidNameMax = "x".repeat(31);
	    validFileNameMin = "1.jpg";
		 validFileNameMid= "12345.jpg";
		 validFileNameMax= "a".repeat(26)+".jpg";
		 invalidFileNameJpgMin = ".jpg";
		 invalidFileNameJpgMax = "x".repeat(27)+".jpg";
		invalidFileNameNoJpgMin = "x".repeat(5);
		invalidFileNameNoJpgMax = "x".repeat(30);
		validStatValueMin = 0;
		validStatValueMid= 50;
		validStatValueMax=100;
		invalidStatValueMin=-1;
		invalidStatValueMax=101;
		validBioZero="";
		validBio= "a";
		invalidBio=null;
		card= new TopTrumpCard();
		
	}
	

	@Test
	void testTopTrumpCardDefualtConstructor() {
	assertNotNull(card);
	}

	@Test
	void testTopTrumpCardConstructorWithValidArgs() {
		card = new TopTrumpCard(validNameMin, validRealNameMin, validFileNameMin, validBioZero, Category.HERO, validStatValueMin, validStatValueMin, validStatValueMin, validStatValueMin);
	assertEquals(validNameMin,card.getName());
	assertEquals(validRealNameMin,card.getRealName());
	assertEquals(validFileNameMin,card.getImageFileName());
	assertEquals(validBioZero, card.getBio());
	assertEquals(validStatValueMin,card.getStrength());
	assertEquals(validStatValueMin,card.getSpeed());
	assertEquals(validStatValueMin,card.getAgility());
	assertEquals(validStatValueMin,card.getIntelligence());
	
	}

	@Test
	void testConstructorInvalidArgsExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			card =new TopTrumpCard(invalidNameMin, validRealNameMin, validFileNameMin, validBio, Category.HERO, validStatValueMin, validStatValueMin, validStatValueMin, validStatValueMin);
		});
		
assertThrows(IllegalArgumentException.class, ()->{
			
			card =new TopTrumpCard(validNameMin, invalidRealNameMin, validFileNameMin, validBio, Category.HERO, validStatValueMin, validStatValueMin, validStatValueMin, validStatValueMin);
		});
		

assertThrows(IllegalArgumentException.class, ()->{
	
	card =new TopTrumpCard(validNameMin, validRealNameMin, invalidFileNameJpgMin, validBio, Category.HERO, validStatValueMin, validStatValueMin, validStatValueMin, validStatValueMin);
});


assertThrows(IllegalArgumentException.class, ()->{
	
	card =new TopTrumpCard(validNameMin, validRealNameMin, validFileNameMin, invalidBio, Category.HERO, invalidStatValueMin, validStatValueMin, validStatValueMin, validStatValueMin);
});


assertThrows(IllegalArgumentException.class, ()->{
	
	card =new TopTrumpCard(validNameMin, validRealNameMin, validFileNameMin, validBio, Category.HERO, validStatValueMin, invalidStatValueMin, validStatValueMin, validStatValueMin);
});
assertThrows(IllegalArgumentException.class, ()->{
	
	card =new TopTrumpCard(validNameMin, validRealNameMin, validFileNameMin, validBio, Category.HERO, validStatValueMin, validStatValueMin, invalidStatValueMin, validStatValueMin);
});
assertThrows(IllegalArgumentException.class, ()->{
	
	card =new TopTrumpCard(validNameMin, validRealNameMin, validFileNameMin, validBio, Category.HERO, validStatValueMin, validStatValueMin, validStatValueMin, invalidStatValueMin);
});

		
	}
	@Test
	void testGetSetNameValid() {
		String expected, actual;
		expected = validNameMin;
		card.setName(expected);
		actual = card.getName();
		assertEquals(expected, actual);
       
		expected = validNameMid;
		card.setName(expected);
		actual = card.getName();
		assertEquals(expected, actual);
		
	
		expected = validNameMax;
		card.setName(expected);
		actual = card.getName();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSetInvalidNameExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
		card.setName(invalidNameMin);
		
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			
			card.setName(invalidNameMax);
			
			});}

	@Test
	void testGetSetRealNameValid() {
	
		String expected, actual;
		expected = validRealNameMin;
		card.setRealName(expected);
		actual = card.getRealName();
		assertEquals(expected, actual);
       
		expected = validRealNameMid;
		card.setRealName(expected);
		actual = card.getRealName();
		assertEquals(expected, actual);
	
		expected = validRealNameMax;
		card.setRealName(expected);
		actual = card.getRealName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetImageFileName() {
		String expected, actual;
		expected = validFileNameMin;
		card.setImageFileName(expected);
		actual = card.getImageFileName();
		assertEquals(expected, actual);
       
		expected = validFileNameMid;
		card.setImageFileName(expected);
		actual = card.getImageFileName();
		assertEquals(expected, actual);
	
		expected = validFileNameMax;
		card.setImageFileName(expected);
		actual = card.getImageFileName();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetInvalidRealNameExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			
		card.setRealName(invalidRealNameMin);
		
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			
			card.setRealName(invalidRealNameMax);
			
			});
		}
	
	@Test
	void testSetInvalidFileNameExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(invalidFileNameNoJpgMin);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(invalidFileNameNoJpgMax);
			
		});
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(invalidFileNameJpgMin);
			
			
		});
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(invalidFileNameJpgMax);
		});
	}

	@Test
	void testSetBio() {
		
		String expected, actual;
		expected = validBio;
		card.setBio(expected);
		actual = card.getBio();
		assertEquals(expected, actual);
		
		
		expected = validBioZero;
		card.setBio(expected);
		actual = card.getBio();
		assertEquals(expected, actual);
	}
	@Test
	void testInvalidBioSetExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			card.setBio(invalidBio);
		});
	}

	@Test
	void testSetCategory() {
		card.setCategory(Category.HERO);
		assertEquals(Category.HERO, card.getCategory());
		card.setCategory(Category.VILLAIN);
		assertEquals(Category.VILLAIN, card.getCategory());
	}

	@Test
	void testSetStrengthValid() {
		int expected, actual;
		expected = validStatValueMin;
		card.setStrength(expected);
		actual = card.getStrength();
		assertEquals(expected, actual);
	
		expected = validStatValueMid;
		card.setStrength(expected);
		actual = card.getStrength();
		assertEquals(expected, actual);

		expected = validStatValueMax;
		card.setStrength(expected);
		actual = card.getStrength();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetinvalidStrengthExpectsExcetion(){
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setStrength(invalidStatValueMin);
		});

		assertThrows(IllegalArgumentException.class, ()->{
			card.setStrength(invalidStatValueMax);
		});
		
	}
	
	@Test
	void testGetAverage() {
		double expected,actual;
		expected = 7.5;
		card.setAgility(10);
		card.setIntelligence(5);
		card.setSpeed(10);
		card.setStrength(5);
		
		actual = card.getAverage();
		assertEquals(expected, actual,0.1);
	}
//
//	}
//
//	@Test
//	void testSetAgility() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetIntelligence() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetMaxStatID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetStatScore() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAverage() {
//		fail("Not yet implemented");
//	}

}
