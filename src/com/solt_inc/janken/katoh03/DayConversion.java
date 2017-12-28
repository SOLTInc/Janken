package com.solt_inc.janken.katoh03;

import java.time.LocalDateTime;

public class DayConversion {

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

		//西暦を返還する（平成編）
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

//		//西暦を返還する（不明編）
//		if(d1.isAfter(LocalDateTime.of(2019, 4, 30, 23, 59))){
//
//			//西暦から和暦に変換する
//			iYear = d1.getYear() - 2019;
//
//			//日付を返す
//			if(iYear == 0){
//				strDay = "〇〇元年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
//			}else{
//				strDay = "〇〇"+ iYear + "年" + d1.getMonthValue() +"月" + d1.getDayOfMonth() + "日";
//			}
//
//			return strDay;
//		}

		//それ以外
		strDay = "和暦は明治・大正・昭和・平成のみ対応しております";

		return strDay;

	}
}
