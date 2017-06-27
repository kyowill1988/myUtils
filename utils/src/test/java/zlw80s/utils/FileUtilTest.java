package zlw80s.utils;

import java.io.File;

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
	
	public void testDeleteFile(){
		
		String path = "D:\\test\\123.txt";
		File file = new File(path);
		FileUtil.DeleteFile(file);
		
	}
	
	public void testDeleteDirectory(){
		
		String path = "D:\\test\\test1";
		File file = new File(path);
		FileUtil.DeleteFile(file);
	}
	
}	
