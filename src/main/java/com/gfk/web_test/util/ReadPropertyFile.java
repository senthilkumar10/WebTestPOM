package com.gfk.web_test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	// This class is executed to read data from properties file
	public static String get(String PropertyName){
		String returnProperty="";
		Properties property = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src//main/resources/config.properties");
			//System.out.println(System.getProperty("user.dir"));
			property.load(file);
			returnProperty=property.getProperty(PropertyName);
			if(returnProperty==null){
				throw new Exception("Property with name : "+PropertyName+" not found in "+System.getProperty("user.dir")+"/src/main/resources/config.properties Please check again");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnProperty;
	}

}
