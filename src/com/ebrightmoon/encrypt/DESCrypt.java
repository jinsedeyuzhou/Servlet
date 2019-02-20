package com.ebrightmoon.encrypt;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESCrypt {
	 public static final String ALGORITHM = "DES";

	    public static byte[] decryptBASE64(String key) throws Exception {
	        return Base64.getDecoder().decode(key);
	    }

	    public static String encryptBASE64(byte[] key) throws Exception {
	        return Base64.getEncoder().encodeToString(key);
	    }

	    private static Key toKey(byte[] key) throws Exception {
	        DESKeySpec dks = new DESKeySpec(key);
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
	        SecretKey secretKey = keyFactory.generateSecret(dks);

	        // ��ʹ�������ԳƼ����㷨ʱ����AES��Blowfish���㷨ʱ�������������滻�������д���
	        // SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);

	        return secretKey;
	    }

	    public static byte[] decrypt(byte[] data, String key) throws Exception {
	        Key k = toKey(decryptBASE64(key));

	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, k);

	        return cipher.doFinal(data);
	    }

	    public static byte[] encrypt(byte[] data, String key) throws Exception {
	        Key k = toKey(decryptBASE64(key));
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, k);

	        return cipher.doFinal(data);
	    }

	    public static String initKey() throws Exception {
	        return initKey(null);
	    }

	    public static String initKey(String seed) throws Exception {
	        SecureRandom secureRandom = null;

	        if (seed != null) {
	            secureRandom = new SecureRandom(decryptBASE64(seed));
	        } else {
	            secureRandom = new SecureRandom();
	        }

	        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
	        kg.init(secureRandom);

	        SecretKey secretKey = kg.generateKey();

	        return encryptBASE64(secretKey.getEncoded());
	    }
}
