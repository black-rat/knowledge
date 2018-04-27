package com.bas.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


import org.apache.commons.codec.binary.Hex;

public class AESUtil {

	/**加密
	 * 因为Java默认不支持16位以上的密码，如果密码为16位以上，则会取中间的16位作为密码
	 * @param content  待加密内容 
	 * @param password 加密密钥 
	 * @return 
	 */  
	public static String encrypt(String input, String key){
		byte[] crypted = null;
		try{
			if(key.length()>16){
				key = disposeKey(key);
			}
			SecretKeySpec skey = new SecretKeySpec(key.getBytes("utf-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes("utf-8"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return Hex.encodeHexString(crypted);
	}
	
	/**解密
	 * 因为Java默认不支持16位以上的密码，如果密码为16位以上，则会取中间的16位作为密码
	 * @param content  待解密内容 
	 * @param password 解密密钥 
	 * @return 
	 */  
	public static String decrypt(String input, String key){
		byte[] output = null;
		try{
			if(key.length()>16){
				key = disposeKey(key);
			}
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Hex.decodeHex(input.toCharArray()));
		}catch(Exception e){
		System.out.println(e.toString());
		}
		return new String(output);
	}
	/**
	 * 处理Key,如果Key的值超过16位，Java默认不支持，所以需要对超过16位的key值进行处理
	 * @param key
	 * @return
	 */
	public static String disposeKey(String key){
		if(key.length()>16){
			int leftIndex = (key.length()-16)/2;
			int rightIndex = leftIndex + 16;
			key = key.substring(leftIndex, rightIndex);
		}
		System.out.println(key);
		return key;
	}
	
	
	public static void main(String[] args) {
		String encode="55f5776a611505f7737adbba9463d43134e9c8865581f6e13b578dcd06f02eac";
		String key="a9A0X?XoB0nY`h;S";
		String content="0121060219901215306X";
		String decrypt = decrypt(encode, key);
		System.out.println(decrypt.equals(content));
		String encrypt = encrypt(content, key);
		System.out.println(encrypt.equals(encode));
	}

	/**加密
	 * 因为Java默认不支持16位以上的密码，如果密码为16位以上，则会取中间的16位作为密码
	 * @param content  待加密内容 
	 * @param password 加密密钥 
	 * @return 
	 */  
/*	public static String encrypt(String input, String key){
		byte[] crypted = null;
		try{
			if(key.length()>16){
				key = disposeKey(key);
			}
			SecretKeySpec skey = new SecretKeySpec(key.getBytes("utf-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes("utf-8"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return  parseByte2HexStr(crypted);
	}
	
	*//**解密
	 * 因为Java默认不支持16位以上的密码，如果密码为16位以上，则会取中间的16位作为密码
	 * @param content  待解密内容 
	 * @param password 解密密钥 
	 * @return 
	 *//*  
	public static String decrypt(String input, String key){
		byte[] output = null;
		try{
			if(key.length()>16){
				key = disposeKey(key);
			}
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Hex.fromHex(input)parseHexStr2Byte(input));
		}catch(Exception e){
		System.out.println(e.toString());
		}
		return new String(output);
	}
	*//**
	 * 处理Key,如果Key的值超过16位，Java默认不支持，所以需要对超过16位的key值进行处理
	 * @param key
	 * @return
	 *//*
	public static String disposeKey(String key){
		if(key.length()>16){
			int leftIndex = (key.length()-16)/2;
			int rightIndex = leftIndex + 16;
			key = key.substring(leftIndex, rightIndex);
		}
		System.out.println(key);
		return key;
	}
	 *//** 
     * 将二进制转换成16进制 
     * 
     * @param buf 
     * @return 
     *//*  
    public static String parseByte2HexStr(byte buf[]) {  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < buf.length; i++) {  
            String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {  
                hex = '0' + hex;  
            }  
            sb.append(hex.toLowerCase());  
        }  
        return sb.toString();  
    }  
    *//** 
     * 将16进制转换为二进制 
     * 
     * @param hexStr 
     * @return 
     *//*  
    public static byte[] parseHexStr2Byte(String hexStr) {  
        if (hexStr.length() < 1) {  
            return null;  
        }  
        byte[] result = new byte[hexStr.length() / 2];  
        for (int i = 0; i < hexStr.length() / 2; i++) {  
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);  
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);  
            result[i] = (byte) (high * 16 + low);  
        }  
        return result;  
    }  
	public static void main(String[] args) {
		String encode="55f5776a611505f7737adbba9463d43134e9c8865581f6e13b578dcd06f02eac";
		String key="a9A0X?XoB0nY`h;S";
		String content="0121060219901215306X";
		String decrypt = decrypt(encode, key);
		System.out.println(decrypt);
		System.out.println(decrypt.equals(content));
		String encrypt = encrypt(content, key);
		System.out.println(encrypt);
		System.out.println(encrypt.equals(encode));
	}*/
}

