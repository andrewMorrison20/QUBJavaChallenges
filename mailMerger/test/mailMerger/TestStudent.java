package mailMerger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStudent {
	String validName, invalidName;
	String validStudentNumber, invalidStudentNumber;
	String validEmail, invalidEmailNoSuffix, invalidEmailSuffixMin;
	String validTimeString, invalidTimeStringFormat, invalidTimeStringLength;
	Student student;

	@BeforeEach
	void setUp() throws Exception {

		validName = "a".repeat(5);
		invalidName = "x".repeat(4);
		validStudentNumber = "1".repeat(7);
		invalidStudentNumber = "1".repeat(6);
		validEmail = "a@example.com";
		invalidEmailNoSuffix = "a".repeat(13);
		invalidEmailSuffixMin = "@example.com";
		validTimeString = "00:00";
		invalidTimeStringFormat = "0000";
		invalidTimeStringFormat = "00:000";
		student = new Student();
	}

	@Test
	void testDefaultConstructor() {
		assertNotNull(student);
	}
	@Test
	void testConstructorWithArgsValid() {
		student = new Student(validName, validStudentNumber, validTimeString, validTimeString, validEmail);
		assertEquals(validName, student.getName());
		assertEquals(validStudentNumber, student.getStudentNumber());
		assertEquals(validTimeString, student.getLogoffString());
		assertEquals(validTimeString, student.getLogonString());
		assertEquals(validEmail, student.getEmailAddress());
		
	}
	
	@Test
	void testConstructorWithArgsInvalidExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student = new Student(invalidName, validStudentNumber, validTimeString, validTimeString, validEmail);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			student = new Student(validName, invalidStudentNumber, validTimeString, validTimeString, validEmail);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			student = new Student(validName, validStudentNumber, invalidTimeStringFormat, validTimeString, validEmail);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			student = new Student(validName, validStudentNumber, validTimeString, invalidTimeStringFormat, validEmail);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			student = new Student(validName, validStudentNumber, validTimeString, validTimeString, invalidEmailNoSuffix);
		});
	}

	@Test
	void testGetSetNameValid() {
		String expected, actual;
		expected= validName;
		student.setName(expected);
		actual = student.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetInvalidNameExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student.setName(invalidName);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setName(null);
		});
	}

	@Test
	void testSetStudentNumber() {
		String expected, actual;
		expected= validStudentNumber;
		student.setStudentNumber(expected);
		actual = student.getStudentNumber();
		assertEquals(expected, actual);
	}
	@Test
	void testSetInvalidStudentNoExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student.setStudentNumber(invalidStudentNumber);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setName(null);
		});
	}
	@Test
	void testSetLogonString() {
		String expected, actual;
		expected= validTimeString;
		student.setLogonString(expected);
		actual = student.getLogonString();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetInvalidLogOnNoExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogonString(invalidTimeStringFormat);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogonString(invalidTimeStringLength);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogonString(null);
		});
		
	}
	@Test
	void testSetLogoffString() {
		String expected, actual;
		expected= validTimeString;
		student.setLogoffString(expected);
		actual = student.getLogoffString();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetInvalidLogOffNoExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogoffString(invalidTimeStringFormat);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogoffString(invalidTimeStringLength);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setLogoffString(null);
		});
		
	}

	@Test
	void testSetEmailAddress() {
		String expected, actual;
		expected= validEmail;
		student.setEmailAddress(expected);
		actual = student.getEmailAddress();
		assertEquals(expected, actual);
	}

	
	@Test
	void testSetInvalidEmailExpectsException() {
		assertThrows(IllegalArgumentException.class, ()->{
			student.setEmailAddress(invalidEmailNoSuffix);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setEmailAddress(invalidEmailSuffixMin);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			student.setEmailAddress(null);
		});
	}
	
	
	@Test
	void testCalcTimeOnLine() {
		student = new Student(validName, validStudentNumber, "09:00", "09:30", validEmail);
		
		assertEquals(30.00,student.calcTimeOnLine(),0.1);
	}

	@Test
	void testMinTimeLogged() {
		student = new Student(validName, validStudentNumber, "09:00", "09:30", validEmail);
		assertFalse(student.minTimeLogged());
	
		student = new Student(validName, validStudentNumber, "09:00", "10:40", validEmail);
		assertTrue(student.minTimeLogged());	
	}

}
