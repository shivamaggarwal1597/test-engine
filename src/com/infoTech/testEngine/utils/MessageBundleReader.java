package com.infoTech.testEngine.utils;

import java.util.ResourceBundle;

//this interface is made for fact that all the messages which are 
//shown to the user...will come from here...its advantage is..
//if we want to change a particular message...then we do not have to
//change it everywhere...instead we change it here only...without 
//touching the code
//here we use the resource bundle class which helps us in doing so
public interface MessageBundleReader {
public static String getValue(String key){
	ResourceBundle rb =ResourceBundle.getBundle("message");
	String value=rb.getString(key);
	
	return value;
	
}
public static String getConfigValue(String key){
	
	ResourceBundle rb =ResourceBundle.getBundle("abc");
	String value=rb.getString(key);
	
	return value;
	
}
public static String getQuesValue(String key){
	ResourceBundle rb =ResourceBundle.getBundle("ques");
	String value=rb.getString(key);
	
	return value;
	
}
}