package zlw80s.utils;

import java.security.MessageDigest;

public class CryptographyUtil {


	public static String encryptByMD5(String source){

		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest(source.getBytes("utf-8"));
			StringBuilder buff = new StringBuilder();

			for(byte b : bs){
				buff.append(String.format("%02X", b));
			}

			return buff.toString().toLowerCase();
		} catch (Exception e) {
			throw new UtilException(e.getLocalizedMessage());
		}
	}

}
