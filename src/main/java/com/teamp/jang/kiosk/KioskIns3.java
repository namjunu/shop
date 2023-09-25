package com.teamp.jang.kiosk;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KioskIns3 extends KioskIns2{
	// 상해 질병 치아 선택시 보여주는 상세목록
	// 여기서는 그냥 가시성을 위해 상해1~3 질병1~3 치아1~3으로 대체
	// 상세 사진은 보험사에서 교체만 하면 끝 
	
	
	protected ImageIcon injury1 = new ImageIcon(getClass().getResource("/JangImages/"+ "상해1" +".png"));
	protected ImageIcon injury2 = new ImageIcon(getClass().getResource("/JangImages/"+ "상해2" +".png"));
	protected ImageIcon injury3 = new ImageIcon(getClass().getResource("/JangImages/"+ "상해3" +".png"));
	
	protected JButton injuryButton1 = new JButton(injury1);
	protected JButton injuryButton2 = new JButton(injury2);
	protected JButton injuryButton3 = new JButton(injury3);
	
	// 상해 버튼 123
	
	protected ImageIcon disease1 = new ImageIcon(getClass().getResource("/JangImages/"+ "질병1" +".png"));
	protected ImageIcon disease2 = new ImageIcon(getClass().getResource("/JangImages/"+ "질병2" +".png"));
	protected ImageIcon disease3 = new ImageIcon(getClass().getResource("/JangImages/"+ "질병3" +".png"));
	
	protected JButton diseaseButton1 = new JButton(disease1);
	protected JButton diseaseButton2 = new JButton(disease2);
	protected JButton diseaseButton3 = new JButton(disease3);
	
	// 질병 버튼 123
	
	protected ImageIcon thooth1 = new ImageIcon(getClass().getResource("/JangImages/"+ "치아1" +".png"));
	protected ImageIcon thooth2 = new ImageIcon(getClass().getResource("/JangImages/"+ "치아2" +".png"));
	protected ImageIcon thooth3 = new ImageIcon(getClass().getResource("/JangImages/"+ "치아3" +".png"));
	
	protected JButton thoothButton1 = new JButton(thooth1);
	protected JButton thoothButton2 = new JButton(thooth2);
	protected JButton thoothButton3 = new JButton(thooth3);
	protected JButton backButton3 = new JButton(backButtonBasic);
	
	// 치아 버튼 123
	
	
	@Override
	public void KioskGUI() {
		super.KioskGUI();
		
		backButton3.setBounds(100, 100, 60, 60);
		backButton3.setBorderPainted(false);
		backButton3.setContentAreaFilled(false);
		backButton3.setFocusPainted(false);
//		backButton3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				backButton3.setIcon(backButtonEntered);
//				// backButton3가 Entered로 변경 
//				backButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				// 마우스 커서를 잡는 모양으로 변경
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// 마우스가 이미지 밖에 있다면 발생하는 함수
//				backButton3.setIcon(backButtonBasic);
//				// backButton3을 Basic로 변경
//				backButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				// 마우스 커서를 기본 모양으로 변경
//			}	
//			@Override
//			public void mousePressed(MouseEvent e) {
//				//마우스로 이미지를 눌렀을때 발생하는 함수
//				
//			}
//		});
		add(backButton3);
		
		injuryButton1.setBounds(300, 300, 200, 200);
		injuryButton1.setBorderPainted(false);
		injuryButton1.setContentAreaFilled(true);
		injuryButton1.setFocusPainted(false);
//		injuryButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해1 선택");
//				// todo 보험옮기기
//			}
//		});
		add(injuryButton1);
		
		injuryButton2.setBounds(550, 300, 200, 200);
		injuryButton2.setBorderPainted(false);
		injuryButton2.setContentAreaFilled(true);
		injuryButton2.setFocusPainted(false);
//		injuryButton2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해2 선택");
//			}
//		});
		add(injuryButton2);
		
		injuryButton3.setBounds(800, 300, 200, 200);
		injuryButton3.setBorderPainted(false);
		injuryButton3.setContentAreaFilled(true);
		injuryButton3.setFocusPainted(false);
//		injuryButton3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해3 선택");
//				// todo 보험옮기기
//			}
//		});
		add(injuryButton3);
		
		//--------------------------------------------------------
		// 상해 버튼 123
		//--------------------------------------------------------
		
		
		diseaseButton1.setBounds(300, 300, 200, 200);
		diseaseButton1.setBorderPainted(false);
		diseaseButton1.setContentAreaFilled(true);
		diseaseButton1.setFocusPainted(false);
//		diseaseButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해1 선택");
//				// todo 보험옮기기
//			}
//		});
		add(diseaseButton1);
		
		diseaseButton2.setBounds(550, 300, 200, 200);
		diseaseButton2.setBorderPainted(false);
		diseaseButton2.setContentAreaFilled(true);
		diseaseButton2.setFocusPainted(false);
//		diseaseButton2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해2 선택");
//			}	
//		});
		add(diseaseButton2);
		
		diseaseButton3.setBounds(800, 300, 200, 200);
		diseaseButton3.setBorderPainted(false);
		diseaseButton3.setContentAreaFilled(true);
		diseaseButton3.setFocusPainted(false);
//		diseaseButton3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해3 선택");
//				// todo 보험옮기기
//			}
//		});
		add(diseaseButton3);
		
		//--------------------------------------------------------
		// 질병 버튼 123
		//--------------------------------------------------------
		
		
		thoothButton1.setBounds(300, 300, 200, 200);
		thoothButton1.setBorderPainted(false);
		thoothButton1.setContentAreaFilled(true);
		thoothButton1.setFocusPainted(false);
//		thoothButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해1 선택");
//				// todo 보험옮기기
//			}
//		});
		add(thoothButton1);
		
		thoothButton2.setBounds(550, 300, 200, 200);
		thoothButton2.setBorderPainted(false);
		thoothButton2.setContentAreaFilled(true);
		thoothButton2.setFocusPainted(false);
//		thoothButton2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해2 선택");
//			}
//		});
		add(thoothButton2);
		
		thoothButton3.setBounds(800, 300, 200, 200);
		thoothButton3.setBorderPainted(false);
		thoothButton3.setContentAreaFilled(true);
		thoothButton3.setFocusPainted(false);
//		thoothButton3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println("상해3 선택");
//				// todo 보험옮기기
//			}
//		});
		add(thoothButton3);

		//--------------------------------------------------------
		// 치아 버튼 123
		//--------------------------------------------------------		
		
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
