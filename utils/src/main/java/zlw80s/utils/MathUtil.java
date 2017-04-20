package zlw80s.utils;

public class MathUtil {
	
	/**
	 * 阶乘
	 */
	public static long factorial(int i){
		
		if(i < 0){
			return 0;
		}else{
			if(i==0){
				return 1;
			}else{
				return i * factorial(i-1);
			}
		}
	}
	
	
	
}
