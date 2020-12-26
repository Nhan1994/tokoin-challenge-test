package com.tokoin.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

public class JsonReader {
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> readJsonFromFile(String path, Type type) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		List<T> objects = (List<T>)  new Gson().fromJson(br, type);
		return objects;
	}
}
