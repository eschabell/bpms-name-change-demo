package com.dst.workitems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;


public class InvokeDatabase implements WorkItemHandler {
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		// extract parameters
	
		String firstName = (String) workItem.getParameter("firstNameIn");
		String lastName = (String) workItem.getParameter("lastNameIn");
		//String docstatus = (String) workItem.getParameter("docsValidIn");
		String docstatus = "false";
		String email = "test@opm.gov";
		
		innvokeDatabase(firstName, lastName, email, docstatus);
		
		manager.completeWorkItem(workItem.getId(), null);
	}
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		
	
	
	}
	
	
	private void innvokeDatabase(String firstName, String lastName, String email, String docstatus){
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 String DB_URL = "jdbc:mysql://localhost:3306/workitem";
		 String USER = "root";
		 String PASS = "root";
		 
		Connection conn = null;
		 Statement stmt = null;
		 try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);

		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql;
		    
		    sql = "INSERT INTO citizen VALUES(default, "
            + "'"+firstName+"', "
            + "'"+lastName+"', "
            + "'"+email+"', "
            + "'"+docstatus+"')";
		    
		    int status = stmt.executeUpdate(sql);

		    //STEP 5: Extract data from result set
//		    while(rs.next()){
//		       //Retrieve by column name
//		       int id  = rs.getInt("id");
//		       String name = rs.getString("name");
//		       String dept = rs.getString("dept");
//		       String salary = rs.getString("salary");
//
//		       //Display values
//		       System.out.print("ID: " + id);
//		       System.out.print(", Name: " + name);
//		       System.out.print(", Dept: " + dept);
//		       System.out.println(", Salary: " + salary);
//		    }
		    //STEP 6: Clean-up environment
		    System.out.println("The insert status is: " + status);
		    stmt.close();
		    conn.close();
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          stmt.close();
		    }catch(SQLException se2){
		    }// nothing we can do
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }//end try		
		
	}
	
	/*
	 * 
	 * private void innvokeDatabase(Integer claimId){
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 String DB_URL = "jdbc:mysql://localhost:3306/workitem";
		 String USER = "root";
		 String PASS = "root";
		 
		Connection conn = null;
		 Statement stmt = null;
		 try{
		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);

		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql;
		    sql = "SELECT id, name, dept, salary FROM employee";
		    ResultSet rs = stmt.executeQuery(sql);

		    //STEP 5: Extract data from result set
		    while(rs.next()){
		       //Retrieve by column name
		       int id  = rs.getInt("id");
		       String name = rs.getString("name");
		       String dept = rs.getString("dept");
		       String salary = rs.getString("salary");

		       //Display values
		       System.out.print("ID: " + id);
		       System.out.print(", Name: " + name);
		       System.out.print(", Dept: " + dept);
		       System.out.println(", Salary: " + salary);
		    }
		    //STEP 6: Clean-up environment
		    rs.close();
		    stmt.close();
		    conn.close();
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          stmt.close();
		    }catch(SQLException se2){
		    }// nothing we can do
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }//end try		
		
	}
	
	 */
	
	public static void main(String[] args){
		
		InvokeDatabase iDb = new InvokeDatabase();
		iDb.innvokeDatabase("Sujay", "Irrinki", "abc@opm.gov", "true");
	
		
	}
}

