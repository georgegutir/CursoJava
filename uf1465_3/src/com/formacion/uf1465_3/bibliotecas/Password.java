package com.formacion.uf1465_3.bibliotecas;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Password {
	public static String obtenerHash(String texto) {
		try {

			byte[] salt = new byte[] { 1, 3, 7, -5, 3, 5, -67, -123, 123, 23, 56, 86, -23, 123, 21, 125 };

			KeySpec spec = new PBEKeySpec(texto.toCharArray(), salt, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			return Base64.getEncoder().encodeToString((factory.generateSecret(spec).getEncoded()));
		} catch (Exception e) {
			throw new RuntimeException("Error no esperado en el hashing del texto", e);
		}
	}
}
