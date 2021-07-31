package com.test.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

	public static ExtentSparkReporter report;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;

	@BeforeSuite
	public void setUp() {

	}

	@AfterSuite
	public void tearDown() {

	}

}
