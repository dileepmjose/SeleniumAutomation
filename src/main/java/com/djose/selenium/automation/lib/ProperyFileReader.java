package com.djose.selenium.automation.lib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.djose.automation.constants.AppConst;

public class ProperyFileReader {

	public String getPropValues(String key) throws IOException {
		String result = "";
		InputStream inputStream = null;
		try {

			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(
					AppConst.RESOURCE_APP_CONFIG_PATH);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ "Application.properties"
						+ "' not found in the classpath");
			}
			Date time = new Date(System.currentTimeMillis());
			result = prop.getProperty(key);
			System.out.println(result + "\nProgram Ran on " + time
					+ " by user=" + result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
