package cn.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 接收来自微信服务器端的验证
 * 
 * @author jj
 *
 */
public class CheckUtil {

	public static final String token = "magicpeng";

	public static boolean check(String signature, String timestamp, String nonce) {
		String[] arrs = new String[] { token, timestamp, nonce };
		Arrays.sort(arrs);// 字典排序
		System.out.println(arrs);
		// 拼接字符串
		StringBuffer sb = new StringBuffer();
		for (String str : arrs) {
			sb.append(str);
		}
		String signaturesha1 = Sha1Util.encode(sb.toString());
		return signaturesha1.equals(signature);
	}

	/**
	 * sha1加密
	 * 
	 * http://blog.csdn.net/guanhang89/article/details/51259283
	 * 
	 * @param str
	 * @return
	 */
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

}
