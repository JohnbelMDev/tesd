package cit285.book.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import cit285.book.domain.Email;
import cit285.book.domain.User;

public class Userdao {

    public void registerEmployee(User user, Email userEmail) throws ClassNotFoundException {
    	userEmail.setEmailid(generateID(1000,9000));
    	user.setUserid(generateID(100000,900000));
    	userEmail.setUserid(user.getUserid());
    	user.setEmail(userEmail);
    	
    	String INSERT_USEREMAIL_SQL = "INSERT INTO email" +
                "  (EmailID, UserID, EmailAddress) VALUES " +
                " (?, ?, ?);";
    	
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (UserID, FirstName, LastName, username, Password, UserType) VALUES " +
            " (?, ?, ?, ?, ?, ?);";


        try {
        	
        	Connection connection = getConnection();

            // Step 2:Create a statement using connection object 
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1,user.getUserid());
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, "User");
            
            PreparedStatement preparedStatementEmail = connection.prepareStatement(INSERT_USEREMAIL_SQL);	
        	preparedStatementEmail.setInt(1,userEmail.getEmailid());
    		preparedStatementEmail.setInt(2, userEmail.getUserid());
    		preparedStatementEmail.setString(3, userEmail.getEmailaddress());

            preparedStatement.executeUpdate();
            preparedStatementEmail.executeUpdate();
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
    }
    
    private static int generateID(int min, int max) {
		Random rnd = new Random();
		int id=0;
		id = min + rnd.nextInt(max);
		return id;
	}
    
    private Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		// 	Load and register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");
		
		// Connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","root");
		System.out.println("Database connected!");
		
		return connection;
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