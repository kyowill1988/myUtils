package zlw80s.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DateTimeUtilTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public DateTimeUtilTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( DateTimeUtilTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */    
	public void testGetDayDiff(){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String bd = "2017-01-01";
		String ed = "2017-01-31";
		try {
			Date beginDate = format.parse(bd);
			Date endDate = format.parse(ed);
			long days = DateTimeUtil.getDayDiff(beginDate,endDate);
			System.out.println(days);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
	}


}
