package com.solt_inc.janken.katoh03;

import java.text.DateFormat;

public class Check {

	//正しいフォーマットかどうか判定する
	public boolean CheckDay(String sDay){

		//正規表現でチェックする
		if(sDay.matches("\\d{4}/\\d{1,2}/\\d{1,2}")){
			//日付かどうか判定する
			if(checkDate(sDay))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	//日付かどうか判定する
	 public static boolean checkDate(String strDate) {
	        DateFormat format = DateFormat.getDateInstance();
	        format.setLenient(false);
	        try {
	            format.parse(strDate);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
