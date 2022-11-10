package com.solvd.agent;

import com.solvd.agent.listener.MyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

@Listeners(MyListener.class)
public class FirstTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void successTest() {
        LOGGER.info("I'm the first test");
    }

    @Test
    public void failTest() {
        LOGGER.info("I'm the second test");
        Assert.fail();
    }
}
