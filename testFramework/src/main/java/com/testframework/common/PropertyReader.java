package com.testframework.common;
import static com.testframework.common.Constants.LOGFILE;
import static com.testframework.common.GetDirectory.getEnv;

//import static com.walmart.common.Constants.propertyConstants.LOGFILE;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class PropertyReader {

	private static final Logger logger = Logger.getLogger(PropertyReader.class);

	public static Properties mainSetings;

	public static void setObjectPaths() {
		PropertyConfigurator.configure(new GetDirectory().getPropertyFile()+LOGFILE);
		mainSetings = readPropertyPaths();
	}

	public static String getConfigItemValue(String configItemName) {
		if (mainSetings == null) {
			logger.debug("Config file to be read for the first time");
			System.out.println(Constants.rootDir
					+ Constants.PROPERTIES_FILE);
			mainSetings=readPropertyPaths();
		}
		return mainSetings.getProperty(configItemName);
	}

	public static Properties readPropertyPaths() {
		Properties pro = new Properties();
		InputStream input = null;
		try {
			getEnv();
			input = new FileInputStream(Constants.rootDir
					+ Constants.PROPERTIES_FILE);
			pro.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return pro;
	}
}