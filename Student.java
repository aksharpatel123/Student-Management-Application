package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	// Using encapsulation these variables will be private
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter Student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Freshmen \n2 - Sophomore \n3 - Junior \n4 - Senior \nEnter Student class level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
		
		// System.out.println(firstName + " " + lastName + " " + gradeYear+" "+studentID);
		
		
	}
	
	// Generate an ID
	private void setStudentID() {
		// ID is 5 character begins with student's grade level
		// Grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// get inside a loop, user hits Q to quit
		
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			
			if (!course.equals("Q")) {
				courses = courses + "\n  " + course;
				tuitionBalance += costOfCourse;
			}
			else {
				break;
			}
		} while(true);
		
		
		// System.out.println("ENROLLED IN: " + courses);
		// System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	// View current balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay Tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show status (formatted string)
	public String toString() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}

}


