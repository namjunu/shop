package com.teamp.jang.kiosk;

import lombok.Data;

@Data
public class KioskDto {
	public String i_name;
	public String i_classfication;
	public String i_selected;
	public String i_selected1;
	public String i_selected2;
	public String i_selected3;
	public String i_selected4;
	public String i_document1;
	public String i_document2;
	public String i_document3;
	public String i_document4;
	public String i_document5;
	public String i_document6;
	
	public KioskDto(String i_name, String i_selected) {
		super();
		this.i_name = i_name;
		this.i_selected = i_selected;
	}
	
	public KioskDto(String i_name, String i_selected1, String i_selected2, String i_selected3, String i_selected4) {
		super();
		this.i_name = i_name;
		this.i_selected1 = i_selected1;
		this.i_selected2 = i_selected2;
		this.i_selected3 = i_selected3;
		this.i_selected4 = i_selected4;
	}
	
	public KioskDto(String i_name, String i_classfication, String i_selected, String i_document1, String i_document2,
			String i_document3, String i_document4, String i_document5, String i_document6) {
		super();
		this.i_name = i_name;
		this.i_classfication = i_classfication;
		this.i_selected = i_selected;
		this.i_document1 = i_document1;
		this.i_document2 = i_document2;
		this.i_document3 = i_document3;
		this.i_document4 = i_document4;
		this.i_document5 = i_document5;
		this.i_document6 = i_document6;
	}
	public KioskDto(String i_name, String i_classfication, String i_selected, String i_document1, String i_document2,
			String i_document3, String i_document4, String i_document5) {
		super();
		this.i_name = i_name;
		this.i_classfication = i_classfication;
		this.i_selected = i_selected;
		this.i_document1 = i_document1;
		this.i_document2 = i_document2;
		this.i_document3 = i_document3;
		this.i_document4 = i_document4;
		this.i_document5 = i_document5;
	}
	public KioskDto(String i_name, String i_classfication, String i_selected, String i_document1, String i_document2,
			String i_document3, String i_document4) {
		super();
		this.i_name = i_name;
		this.i_classfication = i_classfication;
		this.i_selected = i_selected;
		this.i_document1 = i_document1;
		this.i_document2 = i_document2;
		this.i_document3 = i_document3;
		this.i_document4 = i_document4;
	}
	public KioskDto(String i_name, String i_classfication, String i_selected, String i_document1, String i_document2,
			String i_document3) {
		super();
		this.i_name = i_name;
		this.i_classfication = i_classfication;
		this.i_selected = i_selected;
		this.i_document1 = i_document1;
		this.i_document2 = i_document2;
		this.i_document3 = i_document3;
	}


	 public String getISelectedValue(int index) {
	        switch (index) {
	            case 1:
	                return i_selected1;
	            case 2:
	                return i_selected2;
	            case 3:
	                return i_selected3;
	            case 4:
	                return i_selected4;
	            default:
	                return null;
	        }
	 }
	


	
	
	
	// 멤버변수는 field 
	// 객체를 생성하는 시점에서 만들어주기 위해서.
	//
	
	
}
