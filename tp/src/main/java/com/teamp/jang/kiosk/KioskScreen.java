package com.teamp.jang.kiosk;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class KioskScreen extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(getClass().getResource("/JangImages/introBackgroundImage.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getResource("/JangImages/menuBarImage.png")));
	private ImageIcon exitButtonBasic = new ImageIcon(getClass().getResource("/JangImages/exitButtonBasic.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(getClass().getResource("/JangImages/exitButtonEntered.png"));
	
	
	private JButton exitButton = new JButton(exitButtonBasic);

	private int mouseX, mouseY;
	// x값과 y값의 좌표 객체
	boolean isMainScreen = false;
	
	public static KioskIns kioskIns;
	
	public void KioskGUI() {
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// 창을 종료했을때 프로그램 전체가 종료되도록 함
		// 이를 설정하지 않으면 창을 종료하더라도 리소스를 계속 잡아먹어 설정해야한다.
		setVisible(true);
		// 창이 정상적으로 화면에 출력되도록 하게 하는 것
		// 기본값은 false여서 true로 설정해주어야한다
		setBackground(new Color(0, 0, 0, 0));
		// 페인트 컴포넌트를 했을 때 회색이 아닌 하얀색으로 나오게 된다.
		setLayout(null);
		// 버튼이나 JLabel을 넣었을때 정말 그 위치 그 대로 두게 되는 것.
		
		
		
		
		exitButton.setBounds(1245, 0, 30, 30);
		// exit 버튼을 x좌표 1245픽셀 y좌표를 0픽셀위치에서 30*30크기의 사진을 표시
		exitButton.setBorderPainted(false);
		// 테두리 표시 x
		exitButton.setContentAreaFilled(false);
		// 사진 or 그림 이외에 설정한 30*30에서 나머지 화면을 채울것인가? x
		// 누끼(배경화면 제거)설정 해야함
		exitButton.setFocusPainted(false);
		// 외각선 표시 x
		exitButton.addMouseListener(new MouseAdapter() {
			// 마우스 위치에 따른 함수생성
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스가 이미지 위에 있다면 발생하는 이벤트 함수
				exitButton.setIcon(exitButtonEntered);
				// exitButton가 Entered로 변경 
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 마우스 커서를 잡는 모양으로 변경
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 이미지 밖에 있다면 발생하는 함수
				exitButton.setIcon(exitButtonBasic);
				// exitButton을 Basic로 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				// 마우스 커서를 기본 모양으로 변경
			}	
			@Override
			public void mousePressed(MouseEvent e) {
				//마우스로 이미지를 눌렀을때 발생하는 함수
				System.exit(0);
				
				//프로그램 종료
			}
		});
		add(exitButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		// 0,0위치에 1280*30크기의 그림을 보여줌
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setVisible(true);
				menuBar.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// 내장함수 마우스 눌렀을때 발생하는 이벤트
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			// 
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

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		
		
		paintComponents(g);
		// 이미지를 단순하게 스크린 이미지라는 변수안에 그려주는것 외에 따로 JLabel같은 것들을
		// JFrame에 추가하면 그것을 그려주는 것을 의미한다.
		// drawImage로 그리는 방법도 있고
		// 메뉴 바 같은 경우는 항상 존재하는 이미지이고 역동적으로 움직이지 않기 떄문에
		// 하나의 버튼이나 고정된 버튼바는 paintComponents로 그려줄 예정
		// ScreenDraw 함수 내에 paintComponents부분은 메인프레임에 추가된 요소들을 보여주는것
		// add로 추가한 것들
		this.repaint();
		// 프로그램이 종료되는 순간까지 다시 페인트 함수를 불러온다.
		// paint 함수는 JFrame 를 상속받은 이러한 GUI 게임에서 가장 첫번째로 화면을 그려주는 함수
		// 약속된 것이라 바뀌지 않는다.
	}

}
