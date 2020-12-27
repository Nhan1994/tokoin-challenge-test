package com.tokoin.utils;

import java.lang.reflect.Field;

import com.google.gson.annotations.SerializedName;

public class PrintObject {
	
	// Print all searchable fields from object
	public static <T> void printStructureObject(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        for (Field field : fields) {
        	SerializedName serializedName = field.getAnnotation(SerializedName.class);
            System.out.printf(serializedName.value() + "\n");
        }
    }
	
	// print all attribute names and value from object
	public static <T> void appendObjectResult(Object object, StringBuilder strBuilder) {
        Field[] fields = object.getClass().getDeclaredFields();
        strBuilder.append("\n-------------------------------------------------------");
        for (Field field : fields) {
        	field.setAccessible(true);
        	SerializedName serializedName = field.getAnnotation(SerializedName.class);
            try {
//				System.out.printf("\n" + serializedName.value() + "     " + field.get(object));
				strBuilder.append("\n" + serializedName.value() + "     " + field.get(object));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
    }
	
	public static void printHyphen() {
		System.out.println("\n----------------------------------------------------------");
	}
	
	public static void printNoResultFound(String dataType, String term, String value, StringBuilder strBuilder) {
		strBuilder.append("Search "+ dataType + " for " + term + " with a value of " + value);
		strBuilder.append("\nNo result found");
	}
	
}
