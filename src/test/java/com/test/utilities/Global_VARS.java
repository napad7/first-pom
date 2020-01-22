package com.test.utilities;

import java.io.File;

public class Global_VARS {
	
	//browser
	public static final String BROWSER = "chrome";
	public static final String PLATFORM = "linux";
	public static final String ENVIRONMENT = "local";
	public static String DEF_BROWSER = null;
	public static String DEF_PLATFORM = null;
	
	public static final String TARGET_URL = "http://www.practiceselenium.com";
	
	public static String propFile = "/home/random1/eclipse-workspace/PageObjectModel/src/test/java/com/test/utilities/selenium.properties";
	public static final String SE_PROPS = new File(propFile).getAbsolutePath();
	
	public static final int TIMEOUT_MINUTE = 60;
	public static final int TIMEOUT_ELEMENT = 10;

}
