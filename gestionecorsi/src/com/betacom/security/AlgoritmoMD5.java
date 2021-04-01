package com.betacom.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AlgoritmoMD5 {
	public static String convertiMD5(String codice) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(codice.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				buffer.append(String.format("%02x", array[i]));
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException exc) {
			return null;
		}
	}
}
