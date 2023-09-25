package com.teamp.jang.kiosk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskClassfication extends KioskIns {
	
	private ImageIcon injuryImage = new ImageIcon(getClass().getResource("/JangImages/"+ "상해" +".png"));
	private ImageIcon diseaseImage =  new ImageIcon(getClass().getResource("/JangImages/"+ "질병" +".png"));
	private ImageIcon thoothImage = new ImageIcon(getClass().getResource("/JangImages/"+ "치아" +".png"));
	
	private JButton injuryButton = new JButton(injuryImage);
	private JButton diseaseButton = new JButton(diseaseImage);
	private JButton thoothButton = new JButton(thoothImage);
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		injuryButton.setBounds(300, 300, 200, 200);
		injuryButton.setBorderPainted(false);
		injuryButton.setContentAreaFilled(true);
		injuryButton.setFocusPainted(false);
		injuryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("상해 선택");
				// todo 보험옮기기
			}
		});
		add(injuryButton);
		
		diseaseButton.setBounds(550, 300, 200, 200);
		diseaseButton.setBorderPainted(false);
		diseaseButton.setContentAreaFilled(true);
		diseaseButton.setFocusPainted(false);
		diseaseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("질병 선택");
			}
		});
		add(diseaseButton);
		
		thoothButton.setBounds(800, 300, 200, 200);
		thoothButton.setBorderPainted(false);
		thoothButton.setContentAreaFilled(true);
		thoothButton.setFocusPainted(false);
		thoothButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("치아 선택");
				// todo 보험옮기기
			}
		});
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
