package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class UUIDGenertorTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public UUIDGenertorTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( UUIDGenertorTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */    
	public void testUUID(){

		System.out.println(IDGenerator.UUID());         
		assert(true);    	
	}
	
	public void testGetUUIDByName(){
		
		String name = "test";
		System.out.println(IDGenerator.UUID(name));         
		assert(true);    	
	}

	public void testSnowFlake(){
		
		long datacenterId = 2;
		long machineId = 3;		
		System.out.println(IDGenerator.SnowFlake(datacenterId, machineId));
		assert(true);    	
	}
	
	

}
