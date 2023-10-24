package com.teamp.jang.kiosk;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskIns4 extends KioskIns3 {
	// 오른쪽에 선택한 것들 추가
	
	protected String chooseButton;
	protected String selected1 ;
	protected String selected2 ;
	protected String selected3 ;
	protected String selected4 ;
	
	protected ImageIcon selectedImage1 ;
	protected ImageIcon selectedImage2 ;
	protected ImageIcon selectedImage3 ;
	protected ImageIcon selectedImage4 ;
	protected ImageIcon submitImage = new ImageIcon(getClass().getResource("/JangImages/" + "제출" + ".png")); ;
	
	protected JButton selectedButton1 ;
	protected JButton selectedButton2 ;
	protected JButton selectedButton3 ;
	protected JButton selectedButton4 ;
	protected JButton submitButton = new JButton(submitImage); 
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		super.screenDraw(g);
	}
	
	public void selectedButtonshow() {
		if(selected1 != null) {
			selectedImage1 = new ImageIcon(getClass().getResource("/JangImages/" + selected1 + ".png"));
			selectedButton1 = new JButton(selectedImage1);
			selectedButton1.setBounds(1080, 90, 60, 30);
			selectedButton1.setBorderPainted(false);
			selectedButton1.setContentAreaFilled(false);
			selectedButton1.setFocusPainted(false);
//			selectedButton1.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					selectedButton1.setIcon(backButtonEntered);
//					// selectedButton1가 Entered로 변경 
//					selectedButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
//					// 마우스 커서를 잡는 모양으로 변경
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// 마우스가 이미지 밖에 있다면 발생하는 함수
//					selectedButton1.setIcon(backButtonBasic);
//					// selectedButton1을 Basic로 변경
//					selectedButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					// 마우스 커서를 기본 모양으로 변경
//				}	
//				@Override
//				public void mousePressed(MouseEvent e) {
//					//마우스로 이미지를 눌렀을때 발생하는 함수
//					
//				}
//			});
			add(selectedButton1);
			selectedButton1.setVisible(true);
			submitButton.setBounds(1050, 575, 200, 100);
			submitButton.setBorderPainted(false);
			submitButton.setContentAreaFilled(false);
			submitButton.setFocusPainted(false);
			add(submitButton);
			submitButton.setVisible(true);
			
		}else if(selectedButton1==null && selected1==null){
			
		}else {
			selectedButton1.setVisible(false);
		}
		
		if(selected2 != null) {
			selectedImage2 = new ImageIcon(getClass().getResource("/JangImages/" + selected2 + ".png"));
			selectedButton2 = new JButton(selectedImage2);
			selectedButton2.setBounds(1080, 150, 60, 30);
			selectedButton2.setBorderPainted(false);
			selectedButton2.setContentAreaFilled(false);
			selectedButton2.setFocusPainted(false);
//			selectedButton2.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					selectedButton2.setIcon(backButtonEntered);
//					// selectedButton2가 Entered로 변경 
//					selectedButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
//					// 마우스 커서를 잡는 모양으로 변경
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// 마우스가 이미지 밖에 있다면 발생하는 함수
//					selectedButton2.setIcon(backButtonBasic);
//					// selectedButton2을 Basic로 변경
//					selectedButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					// 마우스 커서를 기본 모양으로 변경
//				}	
//				@Override
//				public void mousePressed(MouseEvent e) {
//					//마우스로 이미지를 눌렀을때 발생하는 함수
//					
//				}
//			});
			add(selectedButton2);
			selectedButton2.setVisible(true);
		}else if(selectedButton2==null && selected2==null){
			
		}else {
			selectedButton2.setVisible(false);
		}
		
		if(selected3 != null) {
			selectedImage3 = new ImageIcon(getClass().getResource("/JangImages/" + selected3 + ".png"));
			selectedButton3 = new JButton(selectedImage3);
			selectedButton3.setBounds(1080, 210, 60, 30);
			selectedButton3.setBorderPainted(false);
			selectedButton3.setContentAreaFilled(false);
			selectedButton3.setFocusPainted(false);
//			selectedButton3.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					selectedButton3.setIcon(backButtonEntered);
//					// selectedButton3가 Entered로 변경 
//					selectedButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
//					// 마우스 커서를 잡는 모양으로 변경
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// 마우스가 이미지 밖에 있다면 발생하는 함수
//					selectedButton3.setIcon(backButtonBasic);
//					// selectedButton3을 Basic로 변경
//					selectedButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					// 마우스 커서를 기본 모양으로 변경
//				}	
//				@Override
//				public void mousePressed(MouseEvent e) {
//					//마우스로 이미지를 눌렀을때 발생하는 함수
//					
//				}
//			});
			add(selectedButton3);
			selectedButton3.setVisible(true);
		}else if(selectedButton3==null && selected3==null){
			
		}else {
			selectedButton3.setVisible(false);
		}
		
		if(selected4 != null) {
			selectedImage4 = new ImageIcon(getClass().getResource("/JangImages/" + selected4 + ".png"));
			selectedButton4 = new JButton(selectedImage4);
			selectedButton4.setBounds(1080, 270, 60, 30);
			selectedButton4.setBorderPainted(false);
			selectedButton4.setContentAreaFilled(false);
			selectedButton4.setFocusPainted(false);
//			selectedButton4.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					selectedButton4.setIcon(backButtonEntered);
//					// selectedButton4가 Entered로 변경 
//					selectedButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
//					// 마우스 커서를 잡는 모양으로 변경
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// 마우스가 이미지 밖에 있다면 발생하는 함수
//					selectedButton4.setIcon(backButtonBasic);
//					// selectedButton4을 Basic로 변경
//					selectedButton4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					// 마우스 커서를 기본 모양으로 변경
//				}	
//				@Override
//				public void mousePressed(MouseEvent e) {
//					//마우스로 이미지를 눌렀을때 발생하는 함수
//					
//				}
//			});
			add(selectedButton4);
			selectedButton4.setVisible(true);
		}else if(selectedButton4==null && selected4==null){
			
		}else {
			selectedButton4.setVisible(false);
		}
	}
	
	public void chooseButtonShow() {
		if(selected1==null) {
			selected1 = chooseButton;
			}else if(selected2==null) {
				selected2 = chooseButton;
			}else if(selected3==null) {
				selected3 = chooseButton;
			}else if(selected4==null) {
				selected4 = chooseButton;
			}
	}
	
}
