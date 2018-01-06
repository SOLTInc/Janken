package com.solt_inc.janken.katoh03;

import java.text.DateFormat;

public class Check {

	//正しいフォーマットかどうか判定する
	public int CheckDay(String sDay){


		//正規表現でチェックする（西暦）
		if(sDay.matches("\\d{4}/\\d{1,2}/\\d{1,2}")){
			//日付かどうか判定する
			if(checkDate(sDay))
				return 1;
		}
		//正規表現でチェックする（和暦）
		else if(sDay.matches("(明治|大正|昭和|平成)\\d{1,2}年\\d{1,2}月\\d{1,2}日")){
					return 2;

		}
		//正規表現でチェックする（和暦（元年））
		else if(sDay.matches("(明治元年|大正元年|昭和元年|平成元年)\\d{1,2}月\\d{1,2}日")){
					return 3;

		}
		return 0;

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
