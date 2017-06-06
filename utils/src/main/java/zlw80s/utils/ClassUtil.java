package zlw80s.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	public static void printClassMessage(Object obj){

		Class c = obj.getClass();
		System.out.println("className=" + c.getName());

		printClassMethodMessage(obj);
		printClassFieldMessage(obj);
	}

	public static void printClassMethodMessage(Object obj){

		Class c = obj.getClass();
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

	public static void printClassFieldMessage(Object obj){

		Class c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			System.out.println(field.getType());
			System.out.println(field.getName());
		}
	}
	
	public static void printClassConsMessage(Object obj){
		
		Class c = obj.getClass();
		Constructor[] cons = c.getDeclaredConstructors();
		for(Constructor con : cons){
			System.out.print(con.getName()+"(");
			Class[] types = con.getParameterTypes();
			for(Class type : types){
				System.out.print(type.getName()+',');
			}
			System.out.println(")");
		}
	}

}
