package zlw80s.utils;

import java.lang.reflect.Method;

public class ClassUtil {
	
	public static void printClassMessage(Object obj){
		
		Class c = obj.getClass();
		System.out.println("className=" + c.getName());
		
		//获取public方法
		Method[] ms = c.getMethods();
		for(Method m : ms){
			System.out.println("method="+m.getName());
			System.out.println("methodReturnType="+m.getReturnType());
			System.out.println("methodReturnType="+m.getReturnType().getName());
			
			Class[] paramterTypes = m.getParameterTypes();
			if(paramterTypes.length > 0){
				for(Class type : paramterTypes){
					System.out.println("type="+type.getName());
				}
			}
		}
		
		//获取所有声明的方法,与访问权限无关
		Method[] dms = c.getDeclaredMethods();
		for(Method m : dms){
			System.out.println("method="+m.getName());
			System.out.println("methodReturnType="+m.getReturnType());
		}
		
	}
	
	
}
