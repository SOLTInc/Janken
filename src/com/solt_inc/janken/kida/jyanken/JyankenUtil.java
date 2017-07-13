package com.solt_inc.janken.kida.jyanken;

import java.text.Normalizer;
import java.text.Normalizer.Form;

import com.solt_inc.janken.kida.common.Util;

public class JyankenUtil {

	public int chkJyankenInput(String str) {

		Util utl = new Util();
		int num = utl.exchangeInt(str);

		if (num == 1 || num == 2 || num == 3 || num == 98) {
			return num;
		}

		// 半角カナ、ひらがなの場合も一応対応してやる
		if ("グー".equals(Normalizer.normalize(str, Form.NFKC))
				|| "グー".equals(exchHiraganaKatakana(str))) {

			return 1;
		}

		if ("チョキ".equals(Normalizer.normalize(str, Form.NFKC))
				|| "チョキ".equals(exchHiraganaKatakana(str))) {

			return 2;
		}

		if ("パー".equals(Normalizer.normalize(str, Form.NFKC))
				|| "パー".equals(exchHiraganaKatakana(str))) {

			return 3;
		}
		return 0;

	}

	public String exchangejyanken(int i) {

		if (i == 1) {
			return "グー";
		}

		if (i == 2) {
			return "チョキ";
		}

		if (i == 3) {
			return "パー";
		}

		return null;

	}

	public String exchHiraganaKatakana(String str) {

		final char KATAKANA_SMALL_A = 12449;
		final char HIRAGANA_SMALL_A = 12353;
		final char HIRAGANA_NN = 12531;

		StringBuffer sb = new StringBuffer(str);

		for (int i = 0; i < sb.length(); i++) {

			char c = sb.charAt(i);

			if (c >= HIRAGANA_SMALL_A && c <= HIRAGANA_NN) {

				sb.setCharAt(i,
						(char) (c - HIRAGANA_SMALL_A + KATAKANA_SMALL_A));

			}

		}
		String returnStr = sb.toString();

		return returnStr;

	}

}
