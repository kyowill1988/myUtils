package zlw80s.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class StringUtil {
	
	public static String convert(String s){
		String unicode = "";
		
		char[] charAry = new char[s.length()];
		for(int i = 0;i<s.length();i++){
			charAry[i] = (char)s.charAt(i);
			if(Character.isLetter(charAry[i])&&(charAry[i] > 255)){
				unicode += "\\u" + Integer.toString(charAry[i],16); 
			}
		}
		
		return unicode;
	}
	
	public String readPropertyByKey(String fileName,String key){
		
		Properties props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
			String value = props.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	
	public Map<String,String> readProperties(String fileName){
		
		Map<String,String> maps = new HashMap<>();
		Properties props = new Properties();

		try {
			
			props.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
			Enumeration en = props.propertyNames();
			while(en.hasMoreElements()){
				String key = (String)en.nextElement();
				String value = props.getProperty(key);
				maps.put(key, value);
			}
			
			return maps;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
}
