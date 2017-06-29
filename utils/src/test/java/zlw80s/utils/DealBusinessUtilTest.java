package zlw80s.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DealBusinessUtilTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public DealBusinessUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( DealBusinessUtilTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */    
	public void testGetInterest() throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date beginDate = sdf.parse("2017-01-01");
		Date endDate = sdf.parse("2017-01-31");
		
		BigDecimal amount = new BigDecimal(50000);
		BigDecimal rate = new BigDecimal(0.00035);
		
	    BigDecimal interest = DealBusinessUtil.getInterest(amount, beginDate, endDate, rate);
		System.out.println(interest);
	}


}
