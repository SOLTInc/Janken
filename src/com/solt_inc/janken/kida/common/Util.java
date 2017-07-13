package com.solt_inc.janken.kida.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util {

	/**
	 * 入力値取得処理
	 * 
	 * @return 入力値
	 */
	public String getInput() {

		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = br.readLine();

		} catch (Exception e) {
			// ignore
		}

		return str;

	}

	public boolean chkInput(String str) {

		// 数値型に変換できない場合、false
		try {
			Integer intger = new Integer(str);
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public int exchangeInt(String param) {

		Integer integer = null;

		// 数値型に変換できない場合、0を返す
		try {
			integer = new Integer(param);
		} catch (Exception e) {
			return 0;
		}
		return integer;
	}

}
