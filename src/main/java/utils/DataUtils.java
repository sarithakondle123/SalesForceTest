package utils;

import java.io.FileInputStream;
import java.util.Properties;

import constants.FileConstants;

public class DataUtils {
	
	public static String readLoginTestData(String key) throws Exception
	{
		
		FileInputStream testDataFile = new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p = new Properties();
		p.load(testDataFile);
		return p.getProperty(key);
	}

}
