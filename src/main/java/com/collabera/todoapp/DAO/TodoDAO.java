package com.collabera.todoapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.collabera.todoapp.model.Todo;

@Component
public class TodoDAO {
	
	//crud
	
	public Todo insertTodo(int id, String description, String user, Date targetDate, boolean status) throws SQLException {
		String connectionString="jdbc:mysql://localhost:3306/TodoJDBC";
		String username="sa";
		String password="password";
		Connection myConn = null;
		PreparedStatement myStmt=null;
		ResultSet myRs = null;
		try {
			//1 open the connection
			myConn = DriverManager.getConnection(connectionString,username,password);
			//2 prepare sql statement
				//1. Statement 
					// insert into todo('Column names') values ('')
			myStmt = myConn.prepareStatement("insert into todo(id,user,description,targetDate,status)" + "values(?,?,?,?,?)");
			   //2. Prepare statements
			//myStmt = myConn.prepareStatement(connectionString,PreparedStatement.RETURN_GENERATED_KEYS);
			myStmt.setInt(1,id);
			myStmt.setString(2, user);
			myStmt.setString(3, description);
			myStmt.setDate(4, (java.sql.Date)targetDate);
			myStmt.setString(5, user);
			myStmt.setBoolean(5, status);
				//3. callable statements
						// stored procedures
			// 3 execute
			int result = myStmt.executeUpdate();
			
			// Using the getGeneratedKeys() method to retrieve
	        // the key(s). In this case there is only one key column
//	        ResultSet keyResultSet = myStmt.getGeneratedKeys();
//	        int newCustomerId = 0;
//	        if (keyResultSet.next()) {
//	            newCustomerId = (int) keyResultSet.getInt(1);
//	            customerId = String.valueOf(newCustomerId);
//	        }
	     
			//4 process
			if(result > 0)
				return new Todo(id,user,description,targetDate,status);
			//5 close connection
			return null;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			if(myStmt != null) 
				myStmt.close();
			if(myConn != null)
				myConn.close();	
		}
		return null;
	}
}
