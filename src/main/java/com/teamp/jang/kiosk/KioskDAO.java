package com.teamp.jang.kiosk;

import java.sql.ResultSet;
import java.util.ArrayList;

public class KioskDAO extends KioskDAO_F {

	ResultSet result;
	boolean hasSelected = false;
	
	
	public ArrayList<KioskDto> list(KioskDto dto_Object) {
		ArrayList<KioskDto> posts = new ArrayList<>();
		try {
			super.DB_Con();
			
			if(dto_Object.i_selected1 !=null || dto_Object.i_selected2 !=null || dto_Object.i_selected3 !=null || dto_Object.i_selected4 !=null) {
				hasSelected = true;
			}
			
			if(hasSelected) {
				for(int i = 1 ; i<= 4 ; i++) {
		            String selectedValue = dto_Object.getISelectedValue(i);
					
					String sql = String.format("SELECT * FROM insurance_Board WHERE i_name = '%s' AND i_selected = '%s'" , 
						    dto_Object.i_name, 
						    selectedValue
						);
					
					result = st.executeQuery(sql);
					System.out.println("sql : "+ sql);
					while (result.next()) {
                        posts.add(new KioskDto(
                            result.getString("i_name"),
                            result.getString("i_classfication"),
                            result.getString("i_selected"),
                            result.getString("i_document1"),
                            result.getString("i_document2"),
                            result.getString("i_document3"),
                            result.getString("i_document4"),
                            result.getString("i_document5"),
                            result.getString("i_document6")
                        ));
					}
					
				}
			
			}
			DB_Close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("문제가 있다옹");
			}
		return posts;
	}
	
	}

	
	
	
	

