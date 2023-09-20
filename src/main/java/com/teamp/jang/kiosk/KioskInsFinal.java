package com.teamp.jang.kiosk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class KioskInsFinal extends KioskIns4 {
	
	boolean kioskInsurance1 = false;
	boolean kioskInsurance2 = false;
	boolean kioskInsurance3injury = false;
	boolean kioskInsurance3disease = false;
	boolean kioskInsurance3thooth = false;
	boolean kioskInsurance4 = false;
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		kioskInsurance1 = true;
		
		
		insuranceButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("보험1 선택");
				kioskInsurance1 = false;
				kioskInsurance2 = true;
				kioskInsurance1Show();
				kioskInsurance2Show();
			}
		});
		
		injuryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("상해 선택");
				kioskInsurance2 = false;
				kioskInsurance3injury = true;
				kioskInsurance2Show();
				kioskInsurance3Show();
			}
		});
		
		diseaseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("질병 선택");
				kioskInsurance2 = false;
				kioskInsurance3disease = true;
				kioskInsurance2Show();
				kioskInsurance3Show();
			}
		});
		
		thoothButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("치아 선택");
				kioskInsurance2 = false;
				kioskInsurance3thooth = true;
				kioskInsurance2Show();
				kioskInsurance3Show();
			}
		});
		
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		super.screenDraw(g);
	}
	
	public void kioskInsurance1Show() {
		if(kioskInsurance1) {
		insuranceButton1.setVisible(true);
		insuranceButton2.setVisible(true);
		insuranceButton3.setVisible(true);
		insuranceButton4.setVisible(true);
		insuranceButton5.setVisible(true);
		insuranceButton6.setVisible(true);
		insuranceButton7.setVisible(true);
		insuranceButton8.setVisible(true);
		insuranceButton9.setVisible(true);
		}else if(!kioskInsurance1) {
			insuranceButton1.setVisible(false);
			insuranceButton2.setVisible(false);
			insuranceButton3.setVisible(false);
			insuranceButton4.setVisible(false);
			insuranceButton5.setVisible(false);
			insuranceButton6.setVisible(false);
			insuranceButton7.setVisible(false);
			insuranceButton8.setVisible(false);
			insuranceButton9.setVisible(false);
		}
	}
	
	public void kioskInsurance2Show() {
		if(kioskInsurance2) {
			injuryButton.setVisible(true);
			diseaseButton.setVisible(true);
			thoothButton.setVisible(true);
		}else if(!kioskInsurance2) {
			injuryButton.setVisible(false);
			diseaseButton.setVisible(false);
			thoothButton.setVisible(false);
		}
	}
	
	public void kioskInsurance3Show() {
		if(kioskInsurance3disease) {
			diseaseButton1.setVisible(true);
			diseaseButton2.setVisible(true);
			diseaseButton3.setVisible(true);
			
		}else if(kioskInsurance3injury) {
			injuryButton1.setVisible(true);
			injuryButton2.setVisible(true);
			injuryButton3.setVisible(true);
		}else if(kioskInsurance3thooth) {
			thoothButton1.setVisible(true);
			thoothButton2.setVisible(true);
			thoothButton3.setVisible(true);
			
			
		}else if(!kioskInsurance3disease) {
			diseaseButton1.setVisible(false);
			diseaseButton2.setVisible(false);
			diseaseButton3.setVisible(false);
			
			
		}else if(!kioskInsurance3injury) {
			injuryButton1.setVisible(false);
			injuryButton2.setVisible(false);
			injuryButton3.setVisible(false);
			
			
		}else if(!kioskInsurance3thooth) {
			thoothButton1.setVisible(false);
			thoothButton2.setVisible(false);
			thoothButton3.setVisible(false);
		}
			
	}
	
	public void kioskInsurance4Show() {
		
	}
}
