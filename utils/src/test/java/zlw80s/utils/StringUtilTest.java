package zlw80s.utils;

import java.util.Date;

import javax.sound.midi.Synthesizer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import zlw80s.apps.Apple;

public class StringUtilTest extends TestCase {
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public StringUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( StringUtilTest.class );
	}

	/**
	 * 
	 */    
	public void testConvert(){
		
		String str = "您好";
		System.out.println(StringUtil.convert(str));
		
		String str2 = "世界";
		System.out.println(StringUtil.convert(str2));
		
		
	}
	
	
}	
