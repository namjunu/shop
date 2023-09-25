package com.temp.jang.kiosk;

import java.awt.Color;

import javax.swing.JFrame;

public class KioskScreen extends JFrame {

	public KioskScreen() {
		// 
		setTitle("Jang Kiosk");
		// 만들 창 이름
		setSize(KioskMain.SCREEN_WIDTH, KioskMain.SCREEN_HEIGHT);
		// 게임창 크기를 설정
		setResizable(false);
		// 게임창 크기를 사용자가 임의로 변경할 수 없다.
		setLocationRelativeTo(null);
		// 실행했을떄 화면 정중앙에 오도록 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창을 종료했을때 프로그램 전체가 종료되도록 함
		// 이를 설정하지 않으면 창을 종료하더라도 리소스를 계속 잡아먹어 설정해야한다.
		setVisible(true);
		// 창이 정상적으로 화면에 출력되도록 하게 하는 것
		// 기본값은 false여서 true로 설정해주어야한다
	}
}
