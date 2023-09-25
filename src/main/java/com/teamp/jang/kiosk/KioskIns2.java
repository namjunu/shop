package com.teamp.jang.kiosk;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskIns2 extends KioskIns1 {
	// 보험사 클릭 후 상해 질병 치아 3가지 종류 중 하나 선택
	
	protected ImageIcon injuryImage = new ImageIcon(getClass().getResource("/JangImages/"+ "상해" +".png"));
	protected ImageIcon diseaseImage =  new ImageIcon(getClass().getResource("/JangImages/"+ "질병" +".png"));
	protected ImageIcon thoothImage = new ImageIcon(getClass().getResource("/JangImages/"+ "치아" +".png"));
	// 이미지아이콘 생성
	// 혹시 모를 수정상황 대비로 + + 형식 사용
	
	protected JButton injuryButton = new JButton(injuryImage);
	protected JButton diseaseButton = new JButton(diseaseImage);
	protected JButton thoothButton = new JButton(thoothImage);
	protected JButton backButton2 = new JButton(backButtonBasic);
	// 각각 버튼 생성
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		// 기존 것 그대로 유지
		
		backButton2.setBounds(100, 100, 60, 60);
		backButton2.setBorderPainted(false);
		backButton2.setContentAreaFilled(false);
		backButton2.setFocusPainted(false);
//		backButton2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				backButton2.setIcon(backButtonEntered);
//				// backButton2가 Entered로 변경 
//				backButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				// 마우스 커서를 잡는 모양으로 변경
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// 마우스가 이미지 밖에 있다면 발생하는 함수
//				backButton2.setIcon(backButtonBasic);
//				// backButton2을 Basic로 변경
//				backButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				// 마우스 커서를 기본 모양으로 변경
//			}	
//			@Override
//			public void mousePressed(MouseEvent e) {
//				//마우스로 이미지를 눌렀을때 발생하는 함수
//				
//			}
//		});
		add(backButton2);
		
		
		injuryButton.setBounds(300, 300, 200, 200);
		injuryButton.setBorderPainted(false);
		injuryButton.setContentAreaFilled(true);
		injuryButton.setFocusPainted(false);
//		injuryButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해 선택");
//				// todo 보험옮기기
//			}
//		});
		add(injuryButton);
		
		diseaseButton.setBounds(550, 300, 200, 200);
		diseaseButton.setBorderPainted(false);
		diseaseButton.setContentAreaFilled(true);
		diseaseButton.setFocusPainted(false);
//		diseaseButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("질병 선택");
//			}
//		});
		add(diseaseButton);
		
		thoothButton.setBounds(800, 300, 200, 200);
		thoothButton.setBorderPainted(false);
		thoothButton.setContentAreaFilled(true);
		thoothButton.setFocusPainted(false);
//		thoothButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("치아 선택");
//				// todo 보험옮기기
//			}
//		});
		add(thoothButton);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		super.screenDraw(g);
	}
}
