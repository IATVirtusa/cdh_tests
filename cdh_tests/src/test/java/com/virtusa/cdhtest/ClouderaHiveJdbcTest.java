package com.virtusa.cdhtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClouderaHiveJdbcTest {
	

	private  String SQL_STATEMENT;
	
	// set the impalad host
	private  String HIVE_HOST;
	
	// port 21050 is the default impalad JDBC port 
	private  String HIVE_JDBC_PORT;

	private  String CONNECTION_URL;

	private  String JDBC_DRIVER_NAME;

	private String HIVE_USERNAME;
	private String HIVE_PASSWORD;
  

	
	public ClouderaHiveJdbcTest( )

	{
		System.out.println("Default Constructor used");
		
		SQL_STATEMENT = "select * from order_items limit 50";
		HIVE_HOST = "localhost";
		HIVE_JDBC_PORT = "10000";
		
		CONNECTION_URL = "jdbc:hive2://" + HIVE_HOST
			      + ':' + HIVE_JDBC_PORT + "/default";
		JDBC_DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";
		HIVE_USERNAME = "cloudera";
		HIVE_PASSWORD = "cloudera";

	}
	public ClouderaHiveJdbcTest(String sql,
								String host,
								String jdbc_port,
								String jdbc_name,
								String username,
								String password )

	{

		System.out.println("Default Constructor used");
		
		SQL_STATEMENT = sql;
		HIVE_HOST = host;
		HIVE_JDBC_PORT = jdbc_port;
		
		CONNECTION_URL = "jdbc:hive2://" + HIVE_HOST
			      + ':' + HIVE_JDBC_PORT + "/default";
		JDBC_DRIVER_NAME = jdbc_name;
		HIVE_USERNAME = username;
		HIVE_PASSWORD = password;
		
		
	}
	
	
  	public String getenv()
  		{
  			return ("env details are");
  		}
  	public String get_HIVE_HOST()
  	{
  		return(this.HIVE_HOST);
  	}
  	
  	public void runQuery() throws Exception
  	{

		System.out.println("\n=============================================");
		System.out.println("Cloudera HIVE JDBC ");
		System.out.println("Using Connection URL: " + CONNECTION_URL);
		System.out.println("Running Query: " + SQL_STATEMENT);

		Connection con = null;
		
		

	
			Class.forName(JDBC_DRIVER_NAME);

			con = DriverManager.getConnection(CONNECTION_URL, HIVE_USERNAME,
              HIVE_PASSWORD);

			Statement stmt = con.createStatement();
			

			ResultSet rs = stmt.executeQuery(SQL_STATEMENT);

			System.out.println("\n== Begin Query Results ======================");

			// print the results to the console
			while (rs.next()) {
				// the example query returns one String column
				System.out.println(rs.getString(1));
			}

			System.out.println("== End Query Results =======================\n\n");
			
		
				con.close();
		
  	}
  	

	/*public static void main(String[] args) {

		System.out.println("\n=============================================");
		System.out.println("Cloudera HIVE JDBC ");
		System.out.println("Using Connection URL: " + CONNECTION_URL);
		System.out.println("Running Query: " + SQL_STATEMENT);

		Connection con = null;
		
		

		try {

			Class.forName(JDBC_DRIVER_NAME);

      con =
          DriverManager.getConnection(CONNECTION_URL, HIVE_USERNAME,
              HIVE_PASSWORD);

			Statement stmt = con.createStatement();
			

			ResultSet rs = stmt.executeQuery(SQL_STATEMENT);

			System.out.println("\n== Begin Query Results ======================");

			// print the results to the console
			while (rs.next()) {
				// the example query returns one String column
				System.out.println(rs.getString(1));
			}

			System.out.println("== End Query Results =======================\n\n");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// swallow
			}
		}
	}
*/
	
}
