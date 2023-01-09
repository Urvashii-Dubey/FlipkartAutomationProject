package flipkart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {
	public static Properties prop = null;
	public static File file = null;
	public static FileInputStream fileInputStream = null;

	static {
		{
			file = new File(System.getProperty("user.dir") + "//Resources//config.properties");
			try {
				fileInputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(fileInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
