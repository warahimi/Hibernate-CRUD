package com.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etity.Employee;
import java.util.Scanner;
public class DeletObject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 1- Create a factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).
				buildSessionFactory();
		
		
		try {
			
//			// 2 - create Session
			Session theSession = factory.getCurrentSession();
			theSession.beginTransaction();
			System.out.println("1-Press 1 to delete all recods.\n2-Press 2 to delete specific recod.");
			int d = input.nextInt();
			if (d ==1) {
				theSession.createQuery("delete from Employee").executeUpdate();
			}
			else if (d==2) {
				System.out.print("Enter the Employee ID you want to delete: ");
				int empID = input.nextInt();
				Employee emp = theSession.get(Employee.class, empID);
				Employee readEmp = theSession.get(Employee.class, empID);
				System.out.println(readEmp); // print the object
				System.out.println("================================");
				System.out.println("ID: "+readEmp.getId());
				System.out.println("First Name: "+readEmp.getFirstName());
				System.out.println("Last Name: "+readEmp.getLastName());
				System.out.println("Course: "+readEmp.getCourse());
				System.out.println("Email: "+readEmp.getEmail());
				System.out.println("\nAre you sure you want to delete the above employee? (y/n)");
				
				String choiceString = input.next();
				if(choiceString.equalsIgnoreCase("y"))
				{
					theSession.delete(emp);
				}
				//theSession.createQuery("delete from employee where id= 3").executeUpdate();
				
			}
			else {
				System.out.println("Invalid entry.\nPlease enter 1 or 2");
			}
			

			theSession.getTransaction().commit();
			System.out.println("\nThe object deleted!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
	
		}
		
	}

}
