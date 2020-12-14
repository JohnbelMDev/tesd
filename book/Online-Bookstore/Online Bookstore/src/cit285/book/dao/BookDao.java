package cit285.book.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cit285.book.domain.Author;
import cit285.book.domain.Book;

public class BookDao {
	// Read the statements from file, add to batch and send execute the batch
	public void sendBachToDb(List<String> batches) throws Exception {
		//String line = "";
		//String batch = "";
		//Scanner input = null;
		
		// Get database connection
		Connection connection = getConnection();
		
		// Check if this database support batch updates
		if(connection.getMetaData().supportsBatchUpdates()) {
			
			// Create statement
			Statement statement = connection.createStatement();
			
			// Add batch to the statement
			for (String batch: batches) {
				statement.addBatch(batch);
			}
			
			// Execute the batch
			statement.executeBatch();
		}else {
			System.out.println("Batch updates not supported.");
		}
		System.out.println("Batch sent successfully.");
	}
	
	
	//DELETE BOOK
	
	public static int delete(int id){  
        int status=0;  
        
        String DELETE_BOOK_SQL="DELETE FROM book where BookID = ?";
        try{  
            Connection connection = getConnection();  
            PreparedStatement ps=connection.prepareStatement(DELETE_BOOK_SQL);  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
            
        }catch(Exception e){e.printStackTrace();}  
         
        return status;  
    } 
	
	// UPDATE BOOK 
	
	// ADD BOOK 
	
	public int addBook(Book book, Author author) throws ClassNotFoundException {
		book.setBookid(generateID(1000,9000));
		author.setAuthorid(generateID(10000000,90000000));
		book.setAuthor(author);
		
		String INSERT_AUTHOR_SQL = "INSERT INTO author" +
	            "  (AuthorID, AuthorFirstName, AuthorLastName) VALUES " +
	            " (?,?, ?);";
		
		String INSERT_BOOK_SQL = "INSERT INTO book" +
	            "  (BookID,ISBN, Title, Editor, Edition, Year,AuthorID) VALUES " +
	            " (?,?, ?, ?, ?, ?,?);";

	        int result = 0;

	        try {
	        	Connection connection = getConnection();
	            // Step 2:Create a statement using connection object 
	        		
	        	PreparedStatement preparedStatementAuthor = connection.prepareStatement(INSERT_AUTHOR_SQL);	
	        	preparedStatementAuthor.setInt(1,author.getAuthorid());
        		preparedStatementAuthor.setString(2, author.getAuthorfirstname());
        		preparedStatementAuthor.setString(3, author.getAuthorlastname());
        		
	            PreparedStatement preparedStatementBook = connection.prepareStatement(INSERT_BOOK_SQL) ;
	        		preparedStatementBook.setInt(1,book.getBookid());
	        		preparedStatementBook.setString(2, book.getIsbn());
	        		preparedStatementBook.setString(3, book.getTitle());
	        		preparedStatementBook.setString(4, book.getEditor());
	        		preparedStatementBook.setString(5, book.getEdition());
	        		preparedStatementBook.setInt(6, book.getYear());
	        		preparedStatementBook.setInt(7,author.getAuthorid());
	            
	        	System.out.println(preparedStatementAuthor);
	            System.out.println(preparedStatementBook);
	            // Step 3: Execute the query or update query
	            preparedStatementAuthor.executeUpdate();
	            result = preparedStatementBook.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	}
	
	public List<Book> getBooks() 
			throws SQLException, ClassNotFoundException {
		List<Book> booksList = new ArrayList<>();
		
		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Book");
		
		// Create prepared statement to get Author.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			Book book = new Book();
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			
			// Get the author for this book
			preparedStatement.setInt(1,resultSet.getInt(7));
			ResultSet rset = preparedStatement.executeQuery();
			if(rset.next()) {
				Author author = new Author();
				
				author.setAuthorid(rset.getInt(1));
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
				book.setAuthor(author);
			}
			
			booksList.add(book);
		}
		return booksList;
	}
	
	private static Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		// 	Load and register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");
		
		// Connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","root");
		System.out.println("Database connected!");
		
		return connection;
	}
	
	private static int generateID(int min, int max) {
		Random rnd = new Random();
		int id=0;
		id = min + rnd.nextInt(max);
		return id;
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
