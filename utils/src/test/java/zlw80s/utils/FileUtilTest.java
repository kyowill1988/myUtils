package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileUtilTest extends TestCase {
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public FileUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( FileUtilTest.class );
	}

	/**
	 * 
	 */    
	public void testFileApplicationInfo(){
		
		String path = "D:\\test\\123.txt";
		FileUtil.FileApplicationInfo(path);
	}
	
}	
