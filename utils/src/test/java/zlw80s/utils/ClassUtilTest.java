package zlw80s.utils;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import zlw80s.apps.Apple;

public class ClassUtilTest extends TestCase {
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ClassUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( ClassUtilTest.class );
	}

	/**
	 * 
	 */    
	public void testPrintClassMessage(){
		
		String str = "hello world";
		ClassUtil.printClassMessage(str);
		
	}
	
	public void testPrintFieldMessage(){
		Apple apple = new Apple();
		apple.setId("1");
		apple.setName("One");
		apple.setCreateTime(new Date());
		apple.setAge(10);
		
		ClassUtil.printClassFieldMessage(apple);
		
	}
	
	public void testPrintConsMessage(){
		String str = "hello";
		ClassUtil.printClassConsMessage(str);
	}
	
}	
