package DataDrivenTests;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import Utilities.RestUtils;

public class PostEmployeeRecord extends TestBase {
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	@BeforeClass
public void createEmployee() {
		
		initialize();
		
		JSONObject reqParam = new JSONObject();
		
		reqParam.put("name", empName);
		reqParam.put("salary", empSal);
		reqParam.put("age", empAge);
		
		//Add header
		request.header("Content-Type", "application/json");
		request.body(reqParam.toJSONString());
		
		response = request.post("/create");
  }
	
  //@Test
  
}

/*update emp record
 * response = request.post("/update/"+empID)
 * 
 */
