package com.test.functionalities;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.base.Base;

import io.restassured.response.Response;

public class ValidateTestGETAPITest extends Base {

	@Test
	public void validateValidResponseWithValidURL() {

		Response response = given().get("https://api.spacexdata.com/v4/launches/latest");
		test.log(Status.INFO, response.asString());
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		test.log(Status.PASS, "The response is correct with status "+response.statusCode());
	}
	
	@Test
	public void validateValidResponseWithInValidURL() {
		test.log(Status.INFO, "The test should not give proper response as the URL is made invalid");
		Response response = given().get("https://api.spacexdata.com/v4/launches/latest-invalid");
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 404);
		test.log(Status.PASS, "The response received is "+response.asString());
	}
	
	@Test
	public void validateTheInfformationsGet() {

		Response response = given().get("https://api.spacexdata.com/v4/launches/latest");
		String str=response.asString();
		test.log(Status.INFO, "This test is to validate certain required fields");
		Assert.assertEquals(str.contains("fairings"), true);
		test.log(Status.PASS, "The fairings is populated correctly");
		Assert.assertEquals(str.contains("links"), true);
		test.log(Status.PASS, "The links is populated correctly");
		Assert.assertEquals(str.contains("capsules"), true);
		test.log(Status.PASS, "The capsules is populated correctly");
		Assert.assertEquals(str.contains("payloads"), true);
		test.log(Status.PASS, "The payloads is populated correctly");
		Assert.assertEquals(str.contains("crew"), true);
		test.log(Status.PASS, "The crew is populated correctly");
		Assert.assertEquals(str.contains("name"), true);
		test.log(Status.PASS, "The name is populated correctly");
		Assert.assertEquals(str.contains("cores"), true);
		test.log(Status.PASS, "The cores is populated correctly");
		Assert.assertEquals(str.contains("id"), true);
		test.log(Status.PASS, "The id is populated correctly");
		test.log(Status.PASS, "All the fields mentioned are correct");
	}
	
	@BeforeMethod
	public static void startTest() {
		report = new ExtentSparkReporter(".\\TestReports\\testwebservices.html");
		report.config().setTheme(Theme.STANDARD);
		report.config().setDocumentTitle("Test Case Report");
		test = extent.createTest("The test case for API Test").assignCategory("PositiveScenario");
		extent.attachReporter(report);
	}

	@AfterMethod
	public static void endTest() {
		extent.flush();
	}


}
