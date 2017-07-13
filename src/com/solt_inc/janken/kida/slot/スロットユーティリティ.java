package com.solt_inc.janken.kida.slot;

public class スロットユーティリティ {

	private int SEVENの倍率 = 100;
	private int BARの倍率 = 50;
	private int ダイヤの倍率 = 30;
	private int 四角の倍率 = 10;
	private int 丸三つの倍率 = 5;
	private int 丸二つの倍率 = 5;
	private int 丸一つの倍率 = 2;

	public void 配当表() {
		System.out.println("");
		System.out.println("---------配当表---------");
		System.out.println(" 7   7   7  ・・・×" + SEVENの倍率 + "枚");
		System.out.println("BAR BAR BAR ・・・×" + BARの倍率 + "枚");
		System.out.println(" ◇  ◇  ◇ ・・・×" + ダイヤの倍率 + "枚");
		System.out.println(" □  □  □ ・・・×" + 四角の倍率 + "枚");
		System.out.println(" ○  ○  ○ ・・・×" + 丸三つの倍率 + "枚");
		System.out.println(" ○  ○     ・・・＋" + 丸二つの倍率 + "枚");
		System.out.println(" ○         ・・・＋" + 丸一つの倍率 + "枚");
		System.out.println("------------------------");
		System.out.println("");
	}

	public String 表示用文字作成(int 出た数値) {

		// 7 bar ○ □ ◇
		// if (出た数値 == 1 || 出た数値 == 3 || 出た数値 == 5) {
		// return "○";
		// }

		if (出た数値 >= 1 && 出た数値 <= 10) {
			return "7";
		}

		if (出た数値 >= 11 && 出た数値 <= 25) {
			return "BAR";
		}

		if (出た数値 >= 25 && 出た数値 <= 45) {
			return "◇";
		}

		if (出た数値 >= 45 && 出た数値 <= 70) {
			return "□";
		}
		return "○";
	}

	public int 配当コイン(String 左, String 中, String 右, int 賭けた枚数) {

		if ("7".equals(左) && "7".equals(中) && "7".equals(右)) {
			return 賭けた枚数 * SEVENの倍率;
		}

		if ("BAR".equals(左) && "BAR".equals(中) && "BAR".equals(右)) {
			return 賭けた枚数 * BARの倍率;
		}

		if ("◇".equals(左) && "◇".equals(中) && "◇".equals(右)) {
			return 賭けた枚数 * ダイヤの倍率;
		}

		if ("□".equals(左) && "□".equals(中) && "□".equals(右)) {
			return 賭けた枚数 * 四角の倍率;
		}

		if ("○".equals(左) && "○".equals(中) && "○".equals(右)) {
			return 賭けた枚数 * 丸三つの倍率;
		}

		if ("○".equals(左) && "○".equals(中) || "○".equals(左) && "○".equals(右)
				|| "○".equals(中) && "○".equals(右)) {
			return 賭けた枚数 + 丸二つの倍率;
		}
		if ("○".equals(左) || "○".equals(中) || "○".equals(右)) {
			return 賭けた枚数 + 丸一つの倍率;
		}
		return 0;
	}
}
