package com.CRUD;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etity.Employee;
import java.io.BufferedReader;
import java.util.Scanner;
public class CreateAndSaveObject {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).
				buildSessionFactory();
		// 2 - create Session
		//Session theSession = factory.getCurrentSession();
		
		try {
			String choiceString ="y";
			BufferedReader brReader = new BufferedReader(new java.io.InputStreamReader(System.in));
			while(choiceString.equalsIgnoreCase("y"))
			{
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			System.out.print("Enter Employee Name: ");
			String empfName = input.nextLine();
			System.out.print("Enter Employee Last Name: ");
			String emplName = input.nextLine();
			System.out.print("Enter Employee Course: ");
			String course = input.nextLine();
			System.out.print("Enter Employee Email Address: ");
			String email = input.nextLine();
			Employee emp = new Employee(empfName, emplName, course, email);
			
			//Save the object
			theSession.save(emp);
			
			//Commit
			theSession.getTransaction().commit();
			
			
			System.out.println("Done");
			System.out.println("Do you want to continue? (y/n)");
			choiceString = brReader.readLine();
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
		
	}

}
