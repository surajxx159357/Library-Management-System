package edu.qsp.lms.view;

import edu.qsp.lms.model.*;
import edu.qsp.lms.controller.*;
import java.util.*;

public class View {

	static Scanner myInput=new Scanner(System.in);
	static Library library =new Library();
	
	static Controller controller=new Controller();
	
	static 
	{
		System.out.println("-------WELCOME TO LIBRARY MANAGEMENT SYSTEM--------");
		//
		System.out.print("Enter name of library: ");
		String libraryName=myInput.nextLine();
		library.setLibraryName(libraryName);
		
		System.out.print("enter address of library: ");
		String libraryAddress=myInput.nextLine();
		library.setLibraryAddress(libraryAddress);
		
		System.out.print("enter pincode: ");
		int libraryPincode=myInput.nextInt();
		myInput.nextLine();
		library.setPincode(libraryPincode);
		
		
	}
	public static void main(String[] args) {
	
		/*
 we have to creaste menu of the program 
 do while is best for menu driven program
		*/
		
		do
		{
			System.out.print("Select operation to perform: ");
			System.out.println("\n 1.Add book\n 2.Remove book\n 3.Update book\n 4.Get book by name\n 5.Get all books\n 0.Exit");
			System.out.print("Enter digit respective to desired option: ");
			
			int userChoice=myInput.nextInt();
			myInput.nextLine();
			
			switch(userChoice)
			{
			case 0:
				System.out.println("==========Exited==========");
				myInput.close();
				System.exit(0);
				break;
			case 1:
				Book book1=new Book();
			
				System.out.println("enter a bookname");
				book1.setBookName(myInput.nextLine());
				
				System.out.println("enter bookauthor");
				book1.setBookAuthor(myInput.nextLine());
				
				System.out.println("enter price");
				book1.setBookPrice(myInput.nextDouble());
				myInput.nextLine(); // avoid the problem of space because we can't use integer just after string 
				
				System.out.println("enter publication");
				book1.setPublication(myInput.nextLine());
			
				controller.addBook(book1);
				break;
			case 2:
				System.out.println("Enter name of the book to be removed");
				
				boolean verifyRemoveBook=controller.removeBook(myInput.nextLine());
				if (verifyRemoveBook) {
					System.out.println("Book removed.");
				}
				else
				{
					System.out.println("Book does not existed in library");
				}
				break;
			case 3:
				Book book3=new Book();
				System.out.print("enter name of book to update:");
				book3.setBookName(myInput.nextLine());
				book3.setBookPrice(myInput.nextDouble());
				if(controller.updateBookPriceByBookName(book3))
				{
					System.out.println("Book Updated.");
				}
				else
				{
					System.out.println("Book does not existed in library");
				}
				break;
			case 4:
				System.out.println("enter a book name");
				Book book=controller.searchBook(myInput.nextLine());
				if(book!=null)
				{
					System.out.println(book);
				}
				else
				{
					System.out.println("Book does not existed in library");
				}
				break;
			case 5:
				System.out.println(controller.getAllBooks());
				break;
			default: System.out.println("============INVALID OPTION=============");
				break;
			}
		}while(true);
	}
}
