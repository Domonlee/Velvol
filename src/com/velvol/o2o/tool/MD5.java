package com.velvol.o2o.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private String md5_32;
	private String md5_16;
	public   MD5(String plainText ) { 
		try { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 

		int i; 

		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) { 
		i = b[offset]; 
		if(i<0) i+= 256; 
		if(i<16) 
		buf.append("0"); 
		buf.append(Integer.toHexString(i)); 
		} 
		md5_32=buf.toString();
		md5_16=buf.toString().substring(8,24);
		} catch (NoSuchAlgorithmException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		} 
		}
	public String getMd5_32() {
		return md5_32;
	}
	public String getMd5_16() {
		return md5_16;
	} 
		
}
