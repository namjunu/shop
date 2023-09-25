package com.teamp.jang.kiosk;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class KioskIns1 extends KioskScreen{
	// 보험사 클릭 버튼 생성
	
	
	protected ImageIcon backButtonBasic = new ImageIcon(getClass().getResource("/JangImages/backButtonBasic.png"));
	protected ImageIcon backButtonEntered = new ImageIcon(getClass().getResource("/JangImages/backButtonEntered.png"));
	protected ImageIcon insurance1 = new ImageIcon(getClass().getResource("/JangImages/insurance1.png"));
	protected ImageIcon insurance2 = new ImageIcon(getClass().getResource("/JangImages/insurance2.png"));
	protected ImageIcon insurance3 = new ImageIcon(getClass().getResource("/JangImages/insurance3.png"));
	protected ImageIcon insurance4 = new ImageIcon(getClass().getResource("/JangImages/insurance4.png"));
	protected ImageIcon insurance5 = new ImageIcon(getClass().getResource("/JangImages/insurance5.png"));
	protected ImageIcon insurance6 = new ImageIcon(getClass().getResource("/JangImages/insurance6.png"));
	protected ImageIcon insurance7 = new ImageIcon(getClass().getResource("/JangImages/insurance7.png"));
	protected ImageIcon insurance8 = new ImageIcon(getClass().getResource("/JangImages/insurance8.png"));
	protected ImageIcon insurance9 = new ImageIcon(getClass().getResource("/JangImages/insurance9.png"));
	
	
	protected JButton insuranceButton1 = new JButton(insurance1);
	protected JButton insuranceButton2 = new JButton(insurance2);
	protected JButton insuranceButton3 = new JButton(insurance3);
	protected JButton insuranceButton4 = new JButton(insurance4);
	protected JButton insuranceButton5 = new JButton(insurance5);
	protected JButton insuranceButton6 = new JButton(insurance6);
	protected JButton insuranceButton7 = new JButton(insurance7);
	protected JButton insuranceButton8 = new JButton(insurance8);
	protected JButton insuranceButton9 = new JButton(insurance9);
	
	protected JButton backButton1 = new JButton(backButtonBasic);
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		System.out.println("실행은 되는지 확인");
		
		backButton1.setBounds(100, 100, 60, 60);
		backButton1.setBorderPainted(false);
		backButton1.setContentAreaFilled(false);
		backButton1.setFocusPainted(false);
//		backButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				backButton1.setIcon(backButtonEntered);
//				// backButton1가 Entered로 변경 
//				backButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				// 마우스 커서를 잡는 모양으로 변경
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// 마우스가 이미지 밖에 있다면 발생하는 함수
//				backButton1.setIcon(backButtonBasic);
//				// backButton1을 Basic로 변경
//				backButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				// 마우스 커서를 기본 모양으로 변경
//			}	
//			@Override
//			public void mousePressed(MouseEvent e) {
//				//마우스로 이미지를 눌렀을때 발생하는 함수
//				
//			}
//		});
		add(backButton1);
		
		insuranceButton1.setBounds(300, 50, 200, 200);
		insuranceButton1.setBorderPainted(false);
		insuranceButton1.setContentAreaFilled(true);
		insuranceButton1.setFocusPainted(false);
//		insuranceButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("보험1 선택");
//			}
//		});
		// KioskFianl에 모아서 작성해서 주석처리
		add(insuranceButton1);
		
		insuranceButton2.setBounds(550, 50, 200, 200);
		insuranceButton2.setBorderPainted(false);
		insuranceButton2.setContentAreaFilled(true);
		insuranceButton2.setFocusPainted(false);
		insuranceButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험2 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton2);
		
		insuranceButton3.setBounds(800, 50, 200, 200);
		insuranceButton3.setBorderPainted(false);
		insuranceButton3.setContentAreaFilled(true);
		insuranceButton3.setFocusPainted(false);
		insuranceButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험3 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton3);
		
		insuranceButton4.setBounds(300, 300, 200, 200);
		insuranceButton4.setBorderPainted(false);
		insuranceButton4.setContentAreaFilled(true);
		insuranceButton4.setFocusPainted(false);
		insuranceButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험4 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton4);
		
		insuranceButton5.setBounds(550, 300, 200, 200);
		insuranceButton5.setBorderPainted(false);
		insuranceButton5.setContentAreaFilled(true);
		insuranceButton5.setFocusPainted(false);
		insuranceButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험5 선택");
			}
		});
		add(insuranceButton5);
		
		insuranceButton6.setBounds(800, 300, 200, 200);
		insuranceButton6.setBorderPainted(false);
		insuranceButton6.setContentAreaFilled(true);
		insuranceButton6.setFocusPainted(false);
		insuranceButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험6 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton6);
		
		
		insuranceButton7.setBounds(300, 550, 200, 200);
		insuranceButton7.setBorderPainted(false);
		insuranceButton7.setContentAreaFilled(true);
		insuranceButton7.setFocusPainted(false);
		insuranceButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험7 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton7);
		
		
		insuranceButton8.setBounds(550, 550, 200, 200);
		insuranceButton8.setBorderPainted(false);
		insuranceButton8.setContentAreaFilled(true);
		insuranceButton8.setFocusPainted(false);
		insuranceButton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험8 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton8);
		
		insuranceButton9.setBounds(800, 550, 200, 200);
		insuranceButton9.setBorderPainted(false);
		insuranceButton9.setContentAreaFilled(true);
		insuranceButton9.setFocusPainted(false);
		insuranceButton9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험9 선택");
				// todo 보험옮기기
			}
		});
		add(insuranceButton9);
		
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
