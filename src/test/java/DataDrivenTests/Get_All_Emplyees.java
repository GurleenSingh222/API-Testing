package DataDrivenTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;

public class Get_All_Emplyees extends TestBase {
	
	
	@BeforeClass
	public void getAllEmployees() {
		
		logger.debug("******************Started Get All Employees**************");
		
		initialize();
		response = request.get("/employees");
	}
  @Test
  public void printEmployees() {
	  
	  String resBody = response.getBody().asString();
	  
	  System.out.println(resBody);
  }
}
