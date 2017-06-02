package zlw80s.utils;

/**
 * All rights Reserved
 * @Title:  UtilException.java   
 * @Package zlw80s.utils   
 * @Description: 工具异常类   
 * @author: willzh     
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved.
 */
public class UtilException extends RuntimeException {
	
	private String msg;
	
	public UtilException(){
		
	}
	
	public UtilException(String msg){
		this.msg = msg;
	}
	
}
