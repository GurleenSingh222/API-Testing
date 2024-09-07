package DataDrivenTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddNewEmployees extends TestBase{
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		request = RestAssured.given();
		
	}
	
	RequestSpecification request;
	Response response;
	
  @Test(dataProvider = "empdataprovider")
  public void addNewEmployess(String ename,String eslary,String eage) {
	  
	  JSONObject requestParam = new JSONObject();
	  
	  requestParam.put("name", ename);
	  requestParam.put("salary", eslary);
	  requestParam.put("age", eage);
	  
	  // Add a header stating the request body is a json
	  
	  //request.header("Content-Type","application/json");
	  request.header("Content-Type","application/json; charset=utf-8");
	  
	  //Add the json to the body of the request
	  
	  request.body(requestParam.toJSONString());
	  
	  //post request
	  response = request.post("/create");
	  
	  //capture the response body to perform validation
	  
	  
	  
	  String resBody = response.getBody().asString();
	  
	  System.out.println("Response Body is  " + resBody);
	  //Assert.assertEquals(resBody.contains(ename),true);
	  //Assert.assertEquals(resBody.contains(eslary),true);
	  //Assert.assertEquals(resBody.contains(eage),true);
	  
	  
  }
  @DataProvider(name = "empdataprovider")
   String [][]getEmpData() {
	  
	  String empdata[][] = {{ "abc123","30000","35"},{"xyz123","50000","40"},{"pqrs","55000","55"}};
	  
	  return (empdata);
  }
}
