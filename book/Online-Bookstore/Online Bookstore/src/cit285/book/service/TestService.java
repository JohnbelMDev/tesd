package cit285.book.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cit285.book.dao.BookDao;
import cit285.book.domain.Book;

// Test connection and file batch to the database.
public class TestService {
	
	public static void main(String[] args) 
			throws SQLException, ClassNotFoundException, Exception {
		List<Book> books;
		BookDao bookDao = new BookDao();
		List<String> batches = null;
		
		batches = getBatches();
		bookDao.sendBachToDb(batches);
		
		books = bookDao.getBooks();
		
		for (Book book: books) {
			System.out.print(book.getBookid() + "   ");
			System.out.print(book.getIsbn() + "   ");
			System.out.print(book.getTitle() + "   ");
			System.out.print(book.getEdition() + "   ");
			System.out.print(book.getEditor() + "   ");
			System.out.print(book.getYear() + "   ");
			System.out.print(book.getAuthor().getAuthorfirstname() + " ");
			System.out.print(book.getAuthor().getAuthorlastname());
			System.out.println();
		}
	}
	
	// Read the statements from file, add to batch and send execute the batch
	public static ArrayList<String> getBatches() throws Exception {
		String line = "";
		String batch = "";
		Scanner input = null;
		ArrayList<String> batches = new ArrayList<>();
		
		try {
			// Get the file
			input = new Scanner(new File("createdb.sql"));
			
			// Loop through the file lines.
			while (input.hasNext()) {
				// Read the lines.
				line = input.nextLine();
				
				// Check if the first two characters are -- and skip this line.
				if(line.substring(0,2).equals("--")) {
					
				}else {
					// Check if the first two characters are DE and skip this line.
					if(line.substring(0,2).equals("DE")) {
						
					}else {
						// Check if the first two characters are // and skip it this line.
						if(line.substring(0,2).equals("//")) {
							
						}else {
							// Check if we reach the end of statement and add it to the batch.
							if(line.charAt(line.length() -1) == ';') {
								batch = batch + line.trim();
								batches.add(batch.trim());
								batch = "";
							}else {
								// Add lines to the statement to add to the batch.
								batch = batch + line.trim();
							}
						}
					}
				}
			}
		}catch (FileNotFoundException ex) {
			System.out.println("File not found...");
		}
		System.out.println("Batch sent successfully.");
		
		return batches;
	}
}