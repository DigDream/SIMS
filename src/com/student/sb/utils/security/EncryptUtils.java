package com.student.sb.utils.security;

public class EncryptUtils implements Encrypt {

	public EncryptUtils() {

	}

	public EncryptUtils(Encrypt encrypt) {
		this.encrypt = encrypt;
	}

	private Encrypt encrypt;

	public Encrypt getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(Encrypt encrypt) {
		this.encrypt = encrypt;
	}

	@Override
	public String encode(String source) {
		return encrypt.encode(source);
	}
}
