package com.solvd.agent;

import com.solvd.agent.listener.ZebrunnerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

@Listeners(ZebrunnerListener.class)
public class TestZebrunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void examplePass() {
        Assert.assertEquals("1", "1");
    }

    @Test
    public void exampleFail() {
        Assert.assertEquals("1", "s");
    }

    @Test(dependsOnMethods = {"exampleFail"})
    public void sampleSkipTest() {
        Assert.assertEquals("", "");
    }

    @Test
    public void successTest() {
        LOGGER.info("I'm the success test");
    }
}
