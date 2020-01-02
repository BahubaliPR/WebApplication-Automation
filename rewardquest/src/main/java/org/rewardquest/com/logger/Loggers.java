package org.rewardquest.com.logger;

/*
 * Bahubali P R
 */
public class Loggers {

	public static String getResourcePath(String path) {

		String basePath = System.getProperty("user.dir");
		return basePath + "/" + path;
	}
}
