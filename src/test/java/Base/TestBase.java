package Base;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification request;
	public static Response response;
	public Logger logger;
	
	public static void initialize() {
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		request = RestAssured.given();
		
	}
	
	@BeforeClass
	public void setup() {
		
		/*logger = Logger.getLogger("devpinoyLogger");//add logger
		PropertyConfigurator.configure("log4j.properties");//add logger
		logger.setLevel(Level.DEBUG);*/
		logger = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
	}
	
	

}
