package com.solt_inc.janken.katoh04;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class WarekiConversion {

	//和暦かどうか判定する
	public boolean CheckDay(String sDay){

		//正規表現でチェックする（和暦）
		if(sDay.matches("(明治|大正|昭和|平成)\\d{1,2}年\\d{1,2}月\\d{1,2}日")){
			return true;

		}
		//正規表現でチェックする（和暦（元年））
		if(sDay.matches("(明治元年|大正元年|昭和元年|平成元年)\\d{1,2}月\\d{1,2}日")){
			return true;

		}
		return false;
	}

	//日付かどうか判定する
	public boolean checkDate(String strDate) {
		DateFormat format = DateFormat.getDateInstance();
		format.setLenient(false);
		try {
			format.parse(strDate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//どの和暦か数値で取得する
	public Integer WarekiCheck(String sWareki){

		//明治が含まれるかどうか判定する
		if(sWareki.indexOf("明治") != -1){
			return 1;
		}

		//大正が含まれるかどうか判定する
		if(sWareki.indexOf("大正") != -1){
			return 2;
		}

		//昭和が含まれるかどうか判定する
		if(sWareki.indexOf("昭和") != -1){
			return 3;
		}

		//平成が含まれるかどうか判定する
		if(sWareki.indexOf("平成") != -1){
			return 4;
		}

		return 0;//あり得ない
	}

	//和暦変換
	public String WarekiConversionMain(String sWareki){

		//和暦変換
		String sDay = sWareki;
		String sSplit[];
		Integer iYear;

		sDay = sDay.replace("日","");
		sDay = sDay.replace("月","/");
		sDay = sDay.replace("年","/");
		sDay = sDay.replace("平成元年","1989/1/");
		sDay = sDay.replace("昭和元年","1926/1/");
		sDay = sDay.replace("大正元年","1912/1/");
		sDay = sDay.replace("明治元年","1868/1/");
		sDay = sDay.replace("平成","1989/");
		sDay = sDay.replace("昭和","1926/");
		sDay = sDay.replace("大正","1912/");
		sDay = sDay.replace("明治","1868/");

		//文字を分割する。	Spilit
		sSplit = sDay.split("/",0);

		//日付を作成する
		iYear = Integer.parseInt(sSplit[0]) + Integer.parseInt(sSplit[1]) - 1;	//年を数値で
		sDay = String.valueOf(iYear) + "/" + sSplit[2] + "/" + sSplit[3];		//和暦を作成する

		return sDay;

	}

	//和暦存在チェック
	public boolean WarekiExistenceCheck(String sWareki, Integer iWareki){

		String sDay[];

		//文字を分割する。	Spilit
		sDay = sWareki.split("/",0);

		//文字列を日付に変換する
		LocalDateTime d1 = LocalDateTime.of(Integer.parseInt(sDay[0]), Integer.parseInt(sDay[1]), Integer.parseInt(sDay[2]), 0, 0, 0);

		//明治か判定する
		if(iWareki == 1){
			if(d1.isAfter(LocalDateTime.of(1912, 7, 30, 0, 0))){
				return false;
			}
		}

		//大正か判定する
		if(iWareki == 2){
			if(d1.isAfter(LocalDateTime.of(1926, 12, 25, 0, 0))){
				return false;
			}
		}

		//昭和か判定する
		if(iWareki == 3){
			if(d1.isAfter(LocalDateTime.of(1989, 1, 8, 0, 0))){
				return false;
			}
		}

		//平成か判定する
		if(iWareki == 4){
			if(d1.isAfter(LocalDateTime.of(2019, 5, 1, 0, 0))){
				return false;
			}
		}

		return true;
	}

	//和暦変換(元年)
	public String WarekigannenConversionMain(String sWareki){

		//和暦変換（元年）
		String sDay = sWareki;

		sDay = sDay.replace("日","");
		sDay = sDay.replace("月","/");
		sDay = sDay.replace("平成元年","1989/");
		sDay = sDay.replace("昭和元年","1926/");
		sDay = sDay.replace("大正元年","1912/");
		sDay = sDay.replace("明治元年","1868/");

		return sDay;

	}

	//和暦存在チェック（元年）
	public boolean WarekigannenExistenceCheck(String sWareki){

		String sDay[];

		//文字を分割する。	Spilit
		sDay = sWareki.split("/",0);

		//文字列を日付に変換する
		LocalDateTime d1 = LocalDateTime.of(Integer.parseInt(sDay[0]), Integer.parseInt(sDay[1]), Integer.parseInt(sDay[2]), 0, 0, 0);

		//明治元年か判定する
		if(d1.getYear() == 1868){
			if(d1.isBefore(LocalDateTime.of(1868, 1, 24, 23, 59))){
				return false;
			}
		}

		//大正元年か判定する
		if(d1.getYear() == 1912){
			if(d1.isBefore(LocalDateTime.of(1912, 7, 29, 23, 59))){
				return false;
			}
		}

		//昭和元年か判定する
		if(d1.getYear() == 1926){
			if(d1.isBefore(LocalDateTime.of(1926, 12, 24, 23, 59))){
				return false;
			}
		}

		//平成元年か判定する
		if(d1.getYear() == 1989){
			if(d1.isBefore(LocalDateTime.of(1989, 1, 7, 23, 59))){
				return false;
			}
		}

		return true;
	}
}
