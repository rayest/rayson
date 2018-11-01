package org.rayson.foundation.netty;

import org.springframework.util.StringUtils;

public class ConvertCodeUtils {

	/**
	 * Convert byte[] to hex string.这里我们可以将byte转换成int
	 *
	 * @param src byte[] data
	 * @return hex string
	 */
	public static String bytes2Str(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (byte aSrc : src) {
			int v = aSrc & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * @return 接收字节数据并转为16进制字符串
	 */
	public static String receiveHexToString(byte[] by) {
		try {
			String str = bytes2Str(by);
			if (str == null) {
				return null;
			}
			str = str.toUpperCase();
			return str;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("接收字节数据并转为16进制字符串异常");
		}
		return null;
	}



	public static byte[] HexToByte(String hexString) {
		if(StringUtils.isEmpty(hexString)) {
			hexString = "00";
		}
		byte[] returnBytes = new byte[hexString.length() / 2];
		for (int i = 0; i < returnBytes.length; i++) {
			String temp = hexString.substring((2 * i), ((2 * i) + 2));
			int valueOf = Integer.valueOf(temp, 16);
			returnBytes[i] = (byte) (valueOf & 0xff);
		}
		return returnBytes;
	}

	public static String crc32(byte[] bytes){
			java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
			crc32.update(bytes);
			return formatHexString(Long.toHexString(crc32.getValue()).toUpperCase(),8);
	}

	public static String formatHexString(String str,int len){
		StringBuffer stringBuffer = new StringBuffer();
		if(str!=null&&str.length()<len){
			for (int i = 0; i < len - str.length(); i++) {
				stringBuffer.append("0");
			}
		}
		stringBuffer.append(str);
		return  stringBuffer.toString();
	}
}
