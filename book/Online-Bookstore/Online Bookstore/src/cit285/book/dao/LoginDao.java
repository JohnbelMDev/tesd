package cit285.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cit285.book.domain.Login;

public class LoginDao {

   public int validate(Login loginBean) throws ClassNotFoundException {
        int status = 0;
        //boolean admin =false;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book_store","root","root");
            Statement st = connection.createStatement();
        	ResultSet rs = st.executeQuery("select * from user");
        	while (rs.next()) {
        		if (rs.getString("Username").equals(loginBean.getUsername()) && rs.getString("Password").equals(loginBean.getPassword())){
        			String userType = rs.getString("UserType");
                    if (userType.equals("Admin")) {
                        status = 2;
                        break;
                    }else {
                    	status =1;
                        break;
                    }
        		}
        		else {
        			status = 3;
        			break;
        	}
        	}
        	/*
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from user where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            */
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        System.out.println(status);
        return status;
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