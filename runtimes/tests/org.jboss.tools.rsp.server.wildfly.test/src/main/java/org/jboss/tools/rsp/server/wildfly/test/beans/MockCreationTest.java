package org.jboss.tools.rsp.server.wildfly.test.beans;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class MockCreationTest {
    @Test
    public void testLocateServerMockResources() {
    	String resourceName = "3.2.8.mf.twiddle.jar";
    	File resource = MockServerCreationUtilities.getServerMockResource(resourceName);
    	assertNotNull(resource);
    	assertEquals(resource.getName(), resourceName);
    	File parent = resource.getParentFile();
    	assertTrue(parent.getName().startsWith("serverMock"));
    	assertTrue(resource.exists());
    	
    	File output = MockServerCreationUtilities.getMocksBaseDir();
    	assertNotNull(output);
    }
  }