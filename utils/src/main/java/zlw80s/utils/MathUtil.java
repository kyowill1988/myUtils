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
	
	/**
	 * 计算二维坐标距离
	 * @return
	 */
	public static double distince(double x1,double y1,double x2,double y2){		
		double distince = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return distince;		
	}
	
		
}
