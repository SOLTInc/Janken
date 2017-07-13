package com.solt_inc.janken.kida.data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solt_inc.janken.kida.common.Util;

public class Bean extends BeanSupport {

	private static int jWin;

	private static int jLose;

	private static int jDraw;

	private static int sCoin;

	public static void setMap(HashMap<String, String> mapParam) {
		map = mapParam;
		Util utl = new Util();

		// mapからクラス変数名をキーとして値を取得し値を変数に設定
		// 取得できなかった場合は0を設定
		for (Field field : Bean.class.getDeclaredFields()) {
			String value = map.get(field.getName());
			try {
				field.set(field.getName(), utl.exchangeInt(value));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<String> getSaveData() {

		ArrayList<String> lst = new ArrayList<String>();

		for (Field field : Bean.class.getDeclaredFields()) {
			String fieldName = field.getName();

			String data = "";
			try {
				data = fieldName + ":" + field.get(fieldName);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			lst.add(data);
		}
		return lst;

	}

	public static int getjWin() {
		return jWin;
	}

	public static void setjWin() {
		jWin++;
		Db db = new Db();
		db.saveData();
	}

	public static int getjLose() {
		return jLose;
	}

	public static void setjLose() {
		jLose++;
		Db db = new Db();
		db.saveData();
	}

	public static int getjDraw() {
		return jDraw;
	}

	public static void setjDraw() {
		jDraw++;
		Db db = new Db();
		db.saveData();
	}

	public static int getsCoin() {
		return sCoin;
	}

	public static void coinPlus(int coin) {
		sCoin = sCoin + coin;
		Db db = new Db();
		db.saveData();
	}

	public static void coinMinus(int i) {
		sCoin = sCoin - i;
		Db db = new Db();
		db.saveData();
	}
}
