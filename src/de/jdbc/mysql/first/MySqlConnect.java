package de.jdbc.mysql.first;

import java.io.StringWriter;
//Connection files required
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

/*MySqlConnect class that will follow the 5 basic steps of
 * connection which are:
 * registering the driver class, creating connection,
 * writing queries, receiving result and closing the connection. 
*/ 
public class MySqlConnect {
  private Connection con = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  
  public String getDataBase() throws Exception {
    try {
      // the first step registering mysql driver class	
      Class.forName("com.mysql.jdbc.Driver");
      
      // the second step creating a connection object
      // username "YOUUSERNAME" and password "YOURPASSWORD"
      
      //connection to the database that you have created and write that here
      con = DriverManager.getConnection("jdbc:mysql://localhost/sitepoint?" + "user=root&password=");
      
      // the third step createStatement method to write sql queries
      statement = con.createStatement();
      
      // This is the fourth step of returning the object of resultset
      // Result set get the result of the SQL query
      // comments is the table name and jdbc1 is the database name
      resultSet = statement.executeQuery("select * from sitepoint.employees");
      
      //returning out the result string 
      String result = writeResultSet(resultSet);
      return result;
      
      //PreparedStatements can use variables and are more efficient
      // If you want to insert look at the below query to insert the data into the table
      // Always use ? instead of + as it is inappropriate to use it
      
      // Prepared statement parameters with used for deleting a particular row in the database
      // Parameters start with 1
      
      /*preparedStatement.setString(1, "6");
      preparedStatement.setString(2, "name");
      preparedStatement.setString(3, "location");
      preparedStatement.executeUpdate();
	      preparedStatement = con.prepareStatement("SELECT id, name, location from sitepoint.employess");
      resultSet = preparedStatement.executeQuery();*/
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
	  }
  
  // Printing out all the results of the data entries
  private String writeResultSet(ResultSet resultSet) throws SQLException {
	  JSONArray obj = new JSONArray();
	  while (resultSet.next()) {
		JSONObject obj1 = new JSONObject();
	  	String id = resultSet.getString("CustomerId");
	  	obj1.put("CustomerId", id);
	  	String name = resultSet.getString("CustomerName");
	  	obj1.put("CustomerName", name);
	  	String cname = resultSet.getString("ContactNAme");
	  	obj1.put("ContactNAme", cname);
	  	String addr = resultSet.getString("Address");
	  	obj1.put("Address", addr);
	  	String city = resultSet.getString("City");
	  	obj1.put("City", city);
	  	String postal = resultSet.getString("PostalCode");
	  	obj1.put("PostalCode", postal);
	  	String coun = resultSet.getString("Country");
	  	obj1.put("Country", coun);
	  	obj.add(obj1);	  	
	  }
	  System.out.println(obj);
	  return obj.toString();
  }

  // Closing all the connections
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (con != null) {
        con.close();
      }
    } catch (Exception e) {

    }
  }

}

