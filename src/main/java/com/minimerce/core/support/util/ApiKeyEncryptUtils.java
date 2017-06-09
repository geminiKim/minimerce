package com.minimerce.core.support.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.access.AccessDeniedException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ApiKeyEncryptUtils {
	private static final String MINIMERCE_AES_KEY = "MinimerceIsGood!";
	private static byte[] ivBytes = new byte[16];

	public static String encode(String value) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE,
							new SecretKeySpec(MINIMERCE_AES_KEY.getBytes("UTF-8"), "AES"),
							new IvParameterSpec(ivBytes));
			return removeTrashChar(Base64.encodeBase64String(cipher.doFinal(value.getBytes("UTF-8"))));
		}catch (Exception e) {
			throw new AccessDeniedException("Invalid Api Key");
		}
	}

	public static String decode(String value) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE,
							new SecretKeySpec(MINIMERCE_AES_KEY.getBytes("UTF-8"), "AES"),
							new IvParameterSpec(ivBytes));
			return new String(cipher.doFinal(Base64.decodeBase64(removeTrashChar(value))), "UTF-8");
		}catch (Exception e) {
			throw new AccessDeniedException("Invalid Api Key");
		}
	}

	private static String removeTrashChar(String value) {
		return value.replace("=", "");
	}
}