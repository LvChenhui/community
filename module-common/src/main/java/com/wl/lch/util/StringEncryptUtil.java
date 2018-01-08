package com.wl.lch.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringEncryptUtil {

	protected static Logger logger = LoggerFactory.getLogger(StringEncryptUtil.class);

	private static final String KEY_ALGORITHM = "AES";

	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	/**
	 * 初始化密钥
	 *
	 * @return byte[] 密钥
	 * @throws Exception
	 */
	public static byte[] initSecretKey() {
		// 返回生成指定算法的秘密密钥的 KeyGenerator 对象
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(),e);
			return new byte[0];
		}
		// 初始化此密钥生成器，使其具有确定的密钥大小
		// AES 要求密钥长度为 128
		kg.init(128);
		// 生成一个密钥
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	public static String initSecretKeyStr() {
		// 返回生成指定算法的秘密密钥的 KeyGenerator 对象
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			return "";
		}
		// 初始化此密钥生成器，使其具有确定的密钥大小
		// AES 要求密钥长度为 128
		kg.init(128);
		// 生成一个密钥
		SecretKey secretKey = kg.generateKey();
		return new String(Hex.encodeHex(secretKey.getEncoded()));
	}

	/**
	 * 转换密钥
	 *
	 * @param key
	 *            二进制密钥
	 * @return 密钥
	 */
	private static Key toKey(byte[] key) {
		// 生成密钥
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, Key key) throws Exception {
		return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            二进制密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
	}

	public static String encryptStr(String data, String key)  {
		try {
			return new String(Hex.encodeHex(encrypt(data.getBytes(), Hex.decodeHex(key.toCharArray()),
					DEFAULT_CIPHER_ALGORITHM)));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return data;
		}
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            二进制密钥
	 * @param cipherAlgorithm
	 *            加密算法/工作模式/填充方式
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
		// 还原密钥
		Key k = toKey(key);
		return encrypt(data, k, cipherAlgorithm);
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @param cipherAlgorithm
	 *            加密算法/工作模式/填充方式
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
		// 实例化
		Cipher cipher = Cipher.getInstance(cipherAlgorithm);
		// 使用密钥初始化，设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, key);
		// 执行操作
		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            二进制密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
	}

	public static String decryptStr(String data, String key) {
		try {
			return new String(decrypt(Hex.decodeHex(data.toCharArray()), Hex.decodeHex(key.toCharArray()),
					DEFAULT_CIPHER_ALGORITHM));

		} catch (Exception e) {
			logger.error("data="+data + " ,key=" + key);
			logger.error(e.getMessage(), e);
			return data;
		}
	}

	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, Key key) throws Exception {
		return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
	}

	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            二进制密钥
	 * @param cipherAlgorithm
	 *            加密算法/工作模式/填充方式
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
		// 还原密钥
		Key k = toKey(key);
		return decrypt(data, k, cipherAlgorithm);
	}

	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @param cipherAlgorithm
	 *            加密算法/工作模式/填充方式
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
		// 实例化
		Cipher cipher = Cipher.getInstance(cipherAlgorithm);
		// 使用密钥初始化，设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, key);
		// 执行操作
		return cipher.doFinal(data);
	}

	@SuppressWarnings("unused")
	private static String showByteArray(byte[] data) {
		if (null == data) {
			return null;
		}
		StringBuilder sb = new StringBuilder("{");
		for (byte b : data) {
			sb.append(b).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		// byte[] key = initSecretKey();
		// System.out.println(key.length);
		// System.out.println("key：" + showByteArray(key));
		// System.out.println("key：" + new String(Hex.encodeHex(key)));
		// Key k = toKey(key);
		//
		// String data = "4006333517";
		// System.out.println("加密前数据: string:" + data);
		// System.out.println("加密前数据: byte[]:" +
		// showByteArray(data.getBytes()));
		// System.out.println();
		// byte[] encryptData = encrypt(data.getBytes(), k);
		// System.out.println("加密后数据: byte[]:" + showByteArray(encryptData));
		// System.out.println("加密后数据: string:" + new String(encryptData));
		// byte[] decryptData = decrypt(encryptData, k);
		// System.out.println("解密后数据: byte[]:" + showByteArray(decryptData));
		// System.out.println("解密后数据: string:" + new String(decryptData));
		String encrypt = encryptStr("nhsoft123", "7a46974d55439d11c3b4930ec1e10519");
		System.out.println(encrypt);
		System.out.println(decryptStr("8ba0864d793edee9ce062cd237121836", "258fbdddb27644bef79912b9738fdc2b"));


//		System.out.println(StringEncryptUtil.encryptStr("ABC", "258fbdddb27644bef79912b9738fdc2b"));
//			key = key.replace("-", "");

//		String key = "64-24-78-2A-5A-C3-41-D6-FD-E6-C5-F0";
//		key = key.replace("-", "");
//		if(key.length()>32){
//			key = key.substring(0, 32);
//		}else{
//			key = StringUtils.leftPad(key, 32, "0");
//		}
//		
//		System.out.println(decryptStr("41df8c7e9c4d236f0db6c925bfa281d898a8437d910023c36626e3fdd336a1558d3b54f972685ae7168210efe7d9c298", key));

//		System.out.println(decryptStr("c3818da15d1fcbd436d83c034da5a017b0e1475520a599f6ee18036ee704f597", "00000000C83D07651BDC15DCF73238D5"));

//	    	String password = encryptStr("1234", "7a46974d55439d11c3b4930ec1e10519");
//	    	System.out.println(password);
		System.out.println(decryptStr("6f18283fe9a16d34d29cc9a2be08487ce276e6e59d4004799a80800fbd9a4c926a43a02b92c72bb282d0244c30c259292c001d38206bccdea91aadfef29d7f8e", "000000009374D90874EF383D7012A171"));
//	    	System.out.println(initSecretKey());

		String encrypt1 = encryptStr("nhsoft123", "123412309374D90874EF383D7012A444");
		System.out.println(encrypt1);
		System.out.println(decryptStr("8ba0864d793edee9ce062cd237121836", "sdfsdfgfdjyjbcvb19"));

	}
}
