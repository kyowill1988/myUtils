package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MathUtilTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public MathUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( MathUtilTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */    
	public void testFactorialWhenLessThanZero(){

		int i = -1;
		System.out.println("When Input is "+i+", the result is " +  MathUtil.factorial(i));		
		assert(true);    	
	}

	public void testFactorialEqualZero(){

		int i = 0;
		System.out.println("When Input is "+i+", the result is " + MathUtil.factorial(i));		
		assert(true);    	
	}

	public void testFactorialMoreThanZero(){

		int i = 6;
		System.out.println("When Input is "+i+", the result is " + MathUtil.factorial(i));		
		assert(true);    	
	}

	
	/**
	 * 距离测试
	 */
	public void testdistince(){
		double result = MathUtil.distince(3, 0, 0, 4);			
		assertEquals(result, 5.0);		
	}


}
