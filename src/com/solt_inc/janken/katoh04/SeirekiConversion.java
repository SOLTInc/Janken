package com.solt_inc.janken.katoh04;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class SeirekiConversion {

	//西暦かどうか判定する
	public boolean CheckDay(String sDay){

		//正規表現でチェックする（西暦）
		if(sDay.matches("\\d{4}/\\d{1,2}/\\d{1,2}")){
			//日付かどうか判定する
			if(checkDate(sDay))
				return true;
		}

		return false;
	}

	//西暦チェック
	public String DayConversionMain(LocalDateTime d1){

		//文字列を日付に返す
		String strDay = "";
		int iYear;

		//西暦を返還する（明治編）
		if(d1.isAfter(LocalDateTime.of(1868, 1, 24, 23, 59))  && d1.isBefore(LocalDateTime.of(1912, 7, 30, 0, 0))){

			//西暦から和暦に変換する
			iYear = d1.getYear() - 1867;

			//日付を返す
			if(iYear == 1){
				strDay = "明治元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}else{
				strDay = "明治"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}

			return strDay;
		}

		//西暦を返還する（大正編）
		if(d1.isAfter(LocalDateTime.of(1912, 7, 29, 23, 59))  && d1.isBefore(LocalDateTime.of(1926, 12, 25, 0, 0))){

			//西暦から和暦に変換する
			iYear = d1.getYear() - 1911;

			//日付を返す
			if(iYear == 1){
				strDay = "大正元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}else{
				strDay = "大正"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}

			return strDay;
		}

		//西暦を返還する（昭和編）
		if(d1.isAfter(LocalDateTime.of(1926, 12, 24, 23, 59))  && d1.isBefore(LocalDateTime.of(1989, 1, 8, 0, 0))){

			//西暦から和暦に変換する
			iYear = d1.getYear() - 1925;

			//日付を返す
			if(iYear == 1){
				strDay = "昭和元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}else{
				strDay = "昭和"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}

			return strDay;
		}

		//西暦を変換する（平成編）
		if(d1.isAfter(LocalDateTime.of(1989, 1, 7, 23, 59))  && d1.isBefore(LocalDateTime.of(2019, 5, 1, 0, 0))){

			//西暦から和暦に変換する
			iYear = d1.getYear() - 1988;

			//日付を返す
			if(iYear == 1){
				strDay = "平成元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}else{
				strDay = "平成"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}

			return strDay;
		}

		//西暦を変換する（新元号）
		if(d1.isAfter(LocalDateTime.of(2019, 4, 30, 23, 59))){

			//西暦から和暦に変換する
			iYear = d1.getYear() - 2019;

			//日付を返す
			if(iYear == 0){
				strDay = "新元号元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}else{
				strDay = "新元号"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
			}

			return strDay;
		}

		//それ以外
		strDay = "和暦は明治・大正・昭和・平成のみ対応しております";

		return strDay;

	}


	//日付かどうか判定する
	 private static boolean checkDate(String strDate) {
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
