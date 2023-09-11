package com.teamp.jang.kiosk;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class KioskScreen extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(getClass().getResource("/JangImages/introBackgroundImage.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getResource("/JangImages/menuBar.png")));

	private int mouseX, mouseY;
	// x값과 y값의 좌표 객체

	public KioskScreen() {
		//

		setUndecorated(true);
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
		setBackground(new Color(0, 0, 0, 0));
		// 페인트 컴포넌트를 했을 때 회색이 아닌 하얀색으로 나오게 된다.
		setLayout(null);
		// 버튼이나 JLabel을 넣었을때 정말 그 위치 그 대로 두게 되는 것.

		menuBar.setBounds(0, 0, 1280, 30);
		// 위치와 크기를 설정
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		background = new ImageIcon(getClass().getResource("/JangImages/introBackground.jpg")).getImage();

	}

	public void paint(Graphics g) {
		// paint는 약속된 메소드
		// paint 함수는 JFrame 를 상속받은 이러한 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
		// 약속된 것이라 바뀌지 않는다.

		// 프로그램 화면 크기만큼 이미지를 생성해서 그 이미지를 우리가 screenDraw 함수를 통해
		// 원하는 내용에 맞게 그려준다.
		screenImage = createImage(KioskMain.SCREEN_WIDTH, KioskMain.SCREEN_HEIGHT);
		// 이미지크기를 SCREEN_WIDTH와 SCREEN_HEIGHT 크기에 맞게 만들어 준 뒤에 그것을 스크린 이미지에 넣겠다.
		screenGraphic = screenImage.getGraphics();
		// 스크린 이미지를 이용해서 그래픽 객체를 얻어온다.

		screenDraw((Graphics2D) screenGraphic);
		//
		g.drawImage(screenImage, 0, 0, null);
		// 스크린 이미지를 ( 0, 0 )의 위치에 생성시켜준다

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		this.repaint();
		// 프로그램이 종료되는 순간까지 다시 페인트 함수를 불러온다.
		// paint 함수는 JFrame 를 상속받은 이러한 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
		// 약속된 것이라 바뀌지 않는다.
	}

}
