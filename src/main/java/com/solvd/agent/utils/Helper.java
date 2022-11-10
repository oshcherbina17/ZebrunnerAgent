package com.solvd.agent.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static Map<String, String> jsonMap = new HashMap<>();

    public static String getStartTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String text = sdf.format(date);
        return text;
    }

    public static void setResult(ITestResult testResult) {
        jsonMap.put("endedAt", Helper.getStartTime());
        String result = "";
        switch (testResult.getStatus()) {
            case -1:
                result = "CREATED";
                break;
            case 1:
                result = "SUCCESS";
                break;
            case 2:
                result = "FAILURE";
                break;
            case 3:
                result = "SKIP";
                break;
            case 4:
                result = "SUCCESS_PERCENTAGE_FAILURE";
                break;
            case 16:
                result = "STARTED";
                break;
            default:
        }
        jsonMap.put("result", result);
        System.out.println(jsonMap);
    }
}
