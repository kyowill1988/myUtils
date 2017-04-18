package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IDGenertorTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public IDGenertorTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( IDGenertorTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */    
	public void testGetUUID(){

		UUIDGenerator.getUUID();         
		assert(true);    	
	}
	
	public void testGetUUIDByName(){
		
		String name = "test";
		UUIDGenerator.getUUID(name);         
		assert(true);    	
	}


}
