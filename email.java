
import java.util.Scanner;

public class email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String Email;
	private int mailboxCapacity =500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "stmarysschool.com";
	
	//Constructor to recieve first name and last name
	public email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call a meathod asking for a department
		this.department = setDepartment();
		
		//call a method that return a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//Combine elements to generate email
		Email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	//Ask for department 
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + "\nEnter the department\n1 for Sales\n2 for teacher\n3 for Accounting\n0 for non");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "sales"; }
		else if(depChoice == 2 ) {return "teacher";}
		else if(depChoice == 3) {return "acct";}
		else {return "";}
	}
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the passwords
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "\nDISPLAY NAME : " + firstName + " " + lastName +
				"\nCOMPANY EMAIL:" + Email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
}
