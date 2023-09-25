package com.teamp.jang.kiosk;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	// 자바 줌 사이트 라이브러리 객체 생성
	private boolean isLoop;
	// 현재 곡이 무한 반복인지 한 번만 되는지 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String music, boolean isLoop) {
		// 현재 곡 이름과 반복재생할지 설정
			try {
				this.isLoop= isLoop;
				System.out.println("Music 파일링크 : "+getClass().getResource("/JangMusics/"+music));
				// 자꾸 null이 떠서 디버깅하기 위해 설정함
				
				URI resourceUri = getClass().getResource("/JangMusics/"+music).toURI();
				file = new File(resourceUri);
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
						
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	public void close() {
		// 음악이 언제 실행되던지 끌 수 있도록 하는 함수
		isLoop = false;
		player.close();
		this.interrupt();
		// 해당 스레드를 중지상태로 하는 것.
		// 게임과 별도로 음악을 재생해주는 작은 프로그램이 존재하고 이를 종료해주는 것
	}
	
}
