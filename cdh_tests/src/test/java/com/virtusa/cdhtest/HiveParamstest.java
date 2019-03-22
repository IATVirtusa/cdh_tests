package com.virtusa.cdhtest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.virtusa.cdhtest.*;

public class HiveParamstest {
	 public ClouderaHiveJdbcTest cdhtest;
	 
	@BeforeTest
	  public void beforeTest() {

	
		
		  cdhtest =  new ClouderaHiveJdbcTest( "select * from order_items limit 50",
				  "localhost",
				  "10000",
				  "org.apache.hive.jdbc.HiveDriver",
				  "cloudera",
				  "cloudera");
		  //cdhtest.runQuery();
		 
	  }
	
  @Test
  public void dbcheck() throws Exception {
	
	  cdhtest.runQuery();
	  	
  }
 

  @AfterTest
  public void afterTest() {
  }

}
