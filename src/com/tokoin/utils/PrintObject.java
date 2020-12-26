package com.tokoin.utils;

import java.lang.reflect.Field;

import com.google.gson.annotations.SerializedName;

public class PrintObject {
	
	public static <T> void printStructureObject(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        for (Field field : fields) {
        	SerializedName serializedName = field.getAnnotation(SerializedName.class);
            System.out.printf(serializedName.value() + "\n");
        }
    }
	
	public static void printHyphen() {
		System.out.println("\n----------------------------------------------------------");
	}
}
