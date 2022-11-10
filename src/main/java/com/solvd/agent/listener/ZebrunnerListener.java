package com.solvd.agent.listener;

import com.solvd.agent.api.AuthToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.invoke.MethodHandles;

public class ZebrunnerListener implements ITestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public void onTestStart(ITestResult result) {

        LOGGER.info("ZebrunnerListener >> onTestStart ::" + result.getMethod().getMethodName());
        LOGGER.info("ZebrunnerListener >> getAuthToken ::" + AuthToken.getInstance().getAuthToken());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info("ZebrunnerListener >> onTestSuccess ::" + result.getMethod()
                .getMethodName());
    }


    public void onTestFailure(ITestResult result) {
        LOGGER.info("ZebrunnerListener >> onTestFailure ::" + result.getMethod()
                .getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.info("TestingDocs>> onTestSkipped ::" + result.getMethod()
                .getMethodName());
    }

    public void onStart(ITestContext context) {
        LOGGER.info("TestingDocs>> OnStart ::" + context.getName());
    }

    public void onFinish(ITestContext context) {
        LOGGER.info("****************TestRun Report Header ********************" );
        LOGGER.info("Total Passed" + context.getPassedTests());
        LOGGER.info("Total Failed" + context.getFailedTests());
        LOGGER.info("Total Skipped" + context.getSkippedTests());
        LOGGER.info("***************** TestRun Report Footer ********************" );
    }
}
