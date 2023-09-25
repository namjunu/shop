package com.teamp.jang.kiosk;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class KioskIns extends KioskScreen{
		
	private ImageIcon insurance1 = new ImageIcon(getClass().getResource("/JangImages/insurance1.png"));
	private ImageIcon insurance2 = new ImageIcon(getClass().getResource("/JangImages/insurance2.png"));
	private ImageIcon insurance3 = new ImageIcon(getClass().getResource("/JangImages/insurance3.png"));
	private ImageIcon insurance4 = new ImageIcon(getClass().getResource("/JangImages/insurance4.png"));
	private ImageIcon insurance5 = new ImageIcon(getClass().getResource("/JangImages/insurance5.png"));
	private ImageIcon insurance6 = new ImageIcon(getClass().getResource("/JangImages/insurance6.png"));
	private ImageIcon insurance7 = new ImageIcon(getClass().getResource("/JangImages/insurance7.png"));
	private ImageIcon insurance8 = new ImageIcon(getClass().getResource("/JangImages/insurance8.png"));
	private ImageIcon insurance9 = new ImageIcon(getClass().getResource("/JangImages/insurance9.png"));
	
	private JButton insuranceButton1 = new JButton(insurance1);
	private JButton insuranceButton2 = new JButton(insurance2);
	private JButton insuranceButton3 = new JButton(insurance3);
	private JButton insuranceButton4 = new JButton(insurance4);
	private JButton insuranceButton5 = new JButton(insurance5);
	private JButton insuranceButton6 = new JButton(insurance6);
	private JButton insuranceButton7 = new JButton(insurance7);
	private JButton insuranceButton8 = new JButton(insurance8);
	private JButton insuranceButton9 = new JButton(insurance9);
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		System.out.println("실행은 되는지 확인");
		
		insuranceButton1.setBounds(300, 50, 200, 200);
		insuranceButton1.setBorderPainted(false);
		insuranceButton1.setContentAreaFilled(true);
		insuranceButton1.setFocusPainted(false);
		insuranceButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험1 선택");
				// todo 보험옮기기
			}
		});
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
				// todo 보험옮기기
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
		
		insuranceButton1.setVisible(true);
		insuranceButton2.setVisible(true);
		insuranceButton3.setVisible(true);
		insuranceButton4.setVisible(true);
		insuranceButton5.setVisible(true);
		insuranceButton6.setVisible(true);
		insuranceButton7.setVisible(true);
		insuranceButton8.setVisible(true);
		insuranceButton9.setVisible(true);
	
		
	}
	
	
	
}
