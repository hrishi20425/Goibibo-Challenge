package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	static Properties prop;
	static String path = System.getProperty("user.dir")
			+ "/src/config/config.properties";

	public static void intialize() {
		FileInputStream config_file = null;
		try {
			config_file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(config_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getURL()
	{
		intialize();
		return prop.getProperty("url");
	}
	
	public static String getDriverpath()
	{
		intialize();
		return prop.getProperty("driver_path");
	}
}
