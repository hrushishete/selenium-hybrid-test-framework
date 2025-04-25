package com.practice.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.practice.utilities.Custome_Utilities;

public class Test_Listener implements ITestListener
{

	public static ExtentReports extent;
	public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String TestName=result.getMethod().getMethodName();
		extent =Custome_Utilities.getReportInstance(TestName);
		test=extent.createTest(TestName);
		System.out.println(TestName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("✅ Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("❌ Test Failed");
		test.fail(result.getThrowable());
		try {
			String path=Custome_Utilities.captureScreenShot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test is skiped");
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}}
