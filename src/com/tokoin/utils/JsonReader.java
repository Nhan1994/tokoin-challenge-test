package com.tokoin.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;

public class JsonReader {
	public static String USER_PATH = "";
	public static String TICKET_PATH = "";
	public static String ORGANIZATION_PATH = "";
	public static final String JSON_PATH_FILE = "json.properties";
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> readJsonFromFile(String path, Type type) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		List<T> objects = (List<T>)  new Gson().fromJson(br, type);
		return objects;
	}
	
	public static void getJsonPath() throws FileNotFoundException {
		Properties prop = new Properties();
	    InputStream inputStream = new FileInputStream("resources/" + JSON_PATH_FILE);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			throw new FileNotFoundException("property file '" + JSON_PATH_FILE + "' not found in the classpath");
		}
	    ORGANIZATION_PATH = prop.getProperty("Organization").trim();
	    USER_PATH = prop.getProperty("User");
	    TICKET_PATH = prop.getProperty("Ticket");
	}
}
