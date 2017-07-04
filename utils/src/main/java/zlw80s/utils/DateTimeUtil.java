package zlw80s.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateTimeUtil {
	
	public static void main(String[] args){
		
		foo();
		
	}
	
	/**
	 * 测试数位转换
	 */
	public static void foo(){
		
		String number = "1000";
		
		Map<String,String> dict = new HashMap<String,String>();
		dict.put("0", "零");
		dict.put("1", "一");
		dict.put("2", "二");
		dict.put("3", "三");
		dict.put("4", "四");
		dict.put("5", "五");
		dict.put("6", "六");
		dict.put("7", "七");
		dict.put("8", "八");
		dict.put("9", "九");
		
		String firstChar = number.substring(0, 1);
		String secondChar = number.substring(1, 2);
		String thirdChar = number.substring(2, 3);
		String fourthChar = number.substring(3, 4);
		
		StringBuilder sb = new StringBuilder();
		sb.append(dict.get(firstChar));
		sb.append(dict.get(secondChar));
		sb.append(dict.get(thirdChar));
		sb.append(dict.get(fourthChar));
		
		System.out.println(sb.toString());
		
		
	}
	
	
	public static long getDayDiff(Date beginDate,Date endDate){
		
		long days = 0;
		long nd = 1000 * 60 * 60 * 24;
		days = (endDate.getTime() - beginDate.getTime()) / nd;
		return days;
	}
	
}
