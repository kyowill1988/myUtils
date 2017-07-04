package zlw80s.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易业务帮助类
 * @author willzh
 *
 */
public class DealBusinessUtil {

	
	public static BigDecimal getInterest(BigDecimal amount,Date beginDate,Date endDate,BigDecimal rate){
		
		BigDecimal days = new BigDecimal(DateTimeUtil.getDayDiff(beginDate,endDate));
		BigDecimal oneYearDays = new BigDecimal(365);
		
		return amount.multiply(days).multiply(rate).divide(oneYearDays,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
}
