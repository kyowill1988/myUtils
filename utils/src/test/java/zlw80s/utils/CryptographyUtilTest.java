package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CryptographyUtilTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public CryptographyUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( CryptographyUtilTest.class );
	}

	/**
	 * Rigourous Test
	 */    
	public void testGetUUID(){
		String source = "123456";
		String result = CryptographyUtil.encryptByMD5(source);
		System.out.println("md5 result is:"+result);
	}
	
	
}
