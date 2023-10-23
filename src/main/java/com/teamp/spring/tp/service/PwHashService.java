package com.teamp.spring.tp.service;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PwHashService {
	public String hashPassword(String password) {
		try {
	        // SHA-256 해시 함수를 사용하여 MessageDigest 객체 초기화
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
	        // 입력 비밀번호를 바이트 배열로 변환하여 해싱
	        byte[] hashedBytes = digest.digest(password.getBytes());
	        
	        // 바이트 배열을 16진수 문자열로 변환하여 반환
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hashedBytes) {
	            hexString.append(String.format("%02x", b));
	        }
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        // 예외 처리 (알고리즘이 지원되지 않는 경우)
	        e.printStackTrace();
	        return null;
	    }
	}
}
