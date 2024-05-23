package mailMerger;
import java.time.Duration;
import java.time.LocalTime;
public class Student {
	
	private static final long MIN_TIME_ONLINE = 100;


	private static final int MIN_NAME_LENGTH = 5;


	private static final int MIN_SNUMBER_LENGTH = 7;


	private static final int TIME_STRING_LENGTH = 5;


	private static final int MIN_EMAIL_LENGTH = 13;
	

	/**
	 * name of current student
	 */
	private String name;

	/**
	 * student number of current student
	 */
	private String studentNumber;

	/**
	 * Log on time of current student as a string
	 */
	private String logonString;
	
	/**
	 * logOff time of current student as a string
	 */
	private String logoffString;
	/**
	 * email address of current student
	 */
	private String emailAddress;
	
	
	/**
	 * default constructor - takes no args
	 */
	
	public Student() {
		
	}
	/**
	 * Constructor that takes args - calls relevant setters 
	 * @param name
	 * @param studentNumber
	 * @param logonString
	 * @param logoffString
	 * @param emailAddress
	 */
	
	public Student(String name, String studentNumber, String logonString, String logoffString, String emailAddress) {
		
		this.setName(name);
		this.setStudentNumber(studentNumber); 
		this.setLogonString(logonString);
		this.setLogoffString(logoffString); 
		this.setEmailAddress(emailAddress);
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws IllegalArgumentException {
		if(name ==null || name.length()<MIN_NAME_LENGTH ) {throw new IllegalArgumentException("NAME TOO SHORT");}
		else {
		this.name = name;}
	}
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) throws IllegalArgumentException {
		if (studentNumber == null || studentNumber.length() < MIN_SNUMBER_LENGTH) {
			throw new IllegalArgumentException("SNUMBER TOO SHORT");
		} else {

			this.studentNumber = studentNumber;
		}
	}
	
	
	public String getLogonString() {
		return logonString;
	}

	public void setLogonString(String logonString) throws IllegalArgumentException {
		if (logonString == null || logonString.length() < TIME_STRING_LENGTH
				|| logonString.length() > TIME_STRING_LENGTH) {
			throw new IllegalArgumentException("TIME STRING MUST BE 5 CHARACTERS");
		} else if (logonString.charAt(2) != ':') {
			throw new IllegalArgumentException("incorrect format - must be  nn:nn format");
		} else {
			this.logonString = logonString;
		}
	}
	public String getLogoffString() {
		return logoffString;
	}
	public void setLogoffString(String logoffString)throws IllegalArgumentException {
		
		
		if (logoffString == null || logoffString.length() < TIME_STRING_LENGTH
				|| logoffString.length() > TIME_STRING_LENGTH) {
			throw new IllegalArgumentException("TIME STRING MUST BE 5 CHARACTERS");
		} else if (logoffString.charAt(2) != ':') {
			throw new IllegalArgumentException("incorrect format - must be  nn:nn format");
		} else {
			this.logoffString = logoffString;
		}
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	
	public void setEmailAddress(String emailAddress) throws IllegalArgumentException {
		
		if (emailAddress == null || emailAddress.length()< MIN_EMAIL_LENGTH) {
			throw new IllegalArgumentException("TIME STRING MUST BE 5 CHARACTERS");
		} else if (!emailAddress.endsWith("@example.com")) {
			throw new IllegalArgumentException("incorrect format - must be  a@qub.ac.uk format");
		} else {
			this.emailAddress = emailAddress;
		}
	}
		
	

	                

	// Parse logon and logoff times into LocalTime objects
	
	public long calcTimeOnLine() {
	LocalTime logonTime = LocalTime.parse(logonString);
	LocalTime logoffTime = LocalTime.parse(logoffString);

	// calculate the difference between the times 
	Duration duration = Duration.between(logonTime, logoffTime);

	// get the difference in minutes
	long diffInMinutes = duration.toMinutes();
	return diffInMinutes;
}
	
	public boolean minTimeLogged() {
		
		if(calcTimeOnLine()< MIN_TIME_ONLINE) {
			return false;
		}else {
			return true;
		}
	}
	
	public void showAll () {
		System.out.println();
		System.out.printf("\n%-20s : %s", "Name", name);
		System.out.printf("\n%-20s : %s", "Student Number", studentNumber);
		System.out.printf("\n%-20s : %s", "Email Address", emailAddress);
		System.out.printf("\n%-20s : %s", "Log On Time", logonString);
		System.out.printf("\n%-20s : %s", "Log Off Time", logoffString);
		System.out.printf("\n%-20s : %d", "Time logged", calcTimeOnLine());
		
		
	}
	@Override
	public String toString() {
		return 	
	String.format("\n%-20s : %s \n%-20s : %s\n%-20s : %s \n%-20s : %s \n%-20s : %s \n%-20s : %d", "Name", name, "Student Number", studentNumber, "Email Address", emailAddress, "Log On Time", logonString,
	"Log Off Time", logoffString, "Time logged", calcTimeOnLine());
		
	}
}
