package com.testframework.common;

public class GetDirectory {

	final String rootDir = System.getProperty("user.dir");
	static String ExecutionEnv = System.getProperty("ExecutionEnv");
	final String propdir = "/src/main/resources/ws.config/";
	final String wsdir = "/src/main/resources/ws.url/";

	final String propertyFile = "\\src\\main\\resources\\config\\";
	final static String QAExecutionEnv = "QA";

	public String getPropertyFile() {
		return rootDir + propertyFile;
	}

	public String getPropDir() {
		return rootDir + propdir;
	}

	public static String getEnv() {
		if (ExecutionEnv == null) {
			ExecutionEnv = QAExecutionEnv;
		}return ExecutionEnv;
	}

}
