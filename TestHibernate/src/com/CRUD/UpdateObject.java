package com.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etity.Employee;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class UpdateObject {

	public static void main(String[] args) {
		String x;
		Scanner input = new Scanner(System.in);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).
				buildSessionFactory();
		
		
		try {
			System.out.print("Enter the Employee ID you want to Udate: ");
			int empID = input.nextInt();
			// 2 - create Session
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			Employee emp = theSession.get(Employee.class, empID);
			Employee readEmp = theSession.get(Employee.class, empID);
			if (readEmp == null) {
				System.out.println("THe employee doest exist.\nPlease try again!");
				
			}
			else {
				System.out.println(readEmp); // print the object
				System.out.println("================================");
				System.out.println("ID: "+readEmp.getId());
				System.out.println("First Name: "+readEmp.getFirstName());
				System.out.println("Last Name: "+readEmp.getLastName());
				System.out.println("Course: "+readEmp.getCourse());
				System.out.println("Email: "+readEmp.getEmail());
				System.out.println("\n\nWhat you want to update?\n1. First Name\n2. Last Name\n3. Course\n4. Email");
				int choice = input.nextInt();
				if(choice ==1)
				{
					System.out.print("Enter the new name: ");
					x = bReader.readLine();
					emp.setFirstName(x);
				}
				else if(choice ==2)
				{
					System.out.print("Enter the new last name: ");
					x = bReader.readLine();
					emp.setLastName(x);
				}
				if(choice ==3)
				{
					System.out.print("Enter the new course: ");
					x = bReader.readLine();
					emp.setCourse(x);
				}
				if(choice ==4)
				{
					System.out.print("Enter the new email: ");
					x = bReader.readLine();
					emp.setEmail(x);
				}
				else {
					System.out.println("Invalid Entry");
				}
				
				theSession.getTransaction().commit();
			
			
			}
			
			
		} catch (Exception e) {
			
		}
		finally {
	
		}
		
	}

}
