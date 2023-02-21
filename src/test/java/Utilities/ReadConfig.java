package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "C:\\Users\\lenovo\\eclipse-workspace1\\Tata_EMS_Project\\FIles\\config.properties";

	// constructor
	public ReadConfig() throws IOException {

		properties = new Properties();

		// to open config .properties file in input mode and load the file
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
	}

	public String getbrowser() {

		String value = properties.getProperty("browser");

		if (value != null) {
			return value;
		} else
			throw new RuntimeException("Browser not specified in Config File.");

	}

	public String geturl() {
		String value = properties.getProperty("url");

		if (value != null) {
			return value;
		} else
			throw new RuntimeException("URL not specified in Config File.");
	}
}
