package zlw80s.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SnowFlakeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SnowFlakeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SnowFlakeTest.class );
    }

    /**
     * Rigourous Test :-)
     */    
    public void test(){
    	
    	 SnowFlake snowFlake = new SnowFlake(2, 3);

         for (int i = 0; i < (1 << 12); i++) {
             System.out.println(snowFlake.nextId());
         }
         
         assert(true);    	
    }
    
    
    
    
}
