package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
	
	
}	
