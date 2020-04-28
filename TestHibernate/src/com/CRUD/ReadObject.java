package com.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etity.Employee;
import java.util.Scanner;
public class ReadObject {

//Delete the object 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).
				buildSessionFactory();
		// 2 - create Session
		Session theSession = factory.getCurrentSession();
		
		try {
			System.out.print("Enter the Employee ID you want to read: ");
			int empID = input.nextInt();
			Session theSession2nd = factory.getCurrentSession();
			theSession2nd.beginTransaction();

			Employee readEmp = theSession2nd.get(Employee.class, empID);
			System.out.println(readEmp); // print the object
			System.out.println("================================");
			System.out.println("ID: "+readEmp.getId());
			System.out.println("First Name: "+readEmp.getFirstName());
			System.out.println("Last Name: "+readEmp.getLastName());
			System.out.println("Course: "+readEmp.getCourse());
			System.out.println("Email: "+readEmp.getEmail());
			theSession2nd.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			
		}
		finally {
			theSession.close();
		}
		
	}

}
