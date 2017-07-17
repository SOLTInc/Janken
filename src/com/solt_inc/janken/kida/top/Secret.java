package com.solt_inc.janken.kida.top;

import java.io.File;

import com.solt_inc.janken.kida.common.Util;

class Secret {

	private int delCount = 0;

	boolean isDataClear(int num) {

		if (num == 99999 && delCount == 0) {
			delCount++;
			return false;
		}

		if (num == 1000 && delCount == 1) {
			delCount++;
			return false;
		}

		if (num == 135 && delCount == 2) {
			clear();
			return true;
		}
		clear();
		return false;
	}

	void clear() {
		delCount = 0;
	}

	void dataDelete() {

		System.out.println("データを削除します。宜しいですか？");
		System.out.println("1:YES  それ以外:NO");
		Util utl = new Util();
		String str = utl.getInput();
		System.out.println("");

		if (!"1".equals(str)) {
			System.out.println("削除を止めます。");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			return;
		}

		System.out.println("本当にいいですね？");
		System.out.println("1:YES  それ以外:NO");
		str = utl.getInput();
		System.out.println("");

		if (!"1".equals(str)) {
			System.out.println("削除を止めます。");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			return;
		}

		System.out.println("後悔しませんね？");
		System.out.println("1:YES  それ以外:NO");
		str = utl.getInput();
		System.out.println("");

		if (!"1".equals(str)) {
			System.out.println("削除を止めます。");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			return;
		}

		System.out.println("では、消します");
		System.out.println("1:YES  それ以外:NO");
		str = utl.getInput();
		System.out.println("");

		File file = new File("datafile");
		if (file.delete()) {

		} else {
			System.out.println("ファイルの削除に失敗しました。");
			return;
		}

		if (!"1".equals(str)) {
			System.out.println("今さら遅いです。もう終わりました。");
			System.out.println("");
			System.out.println("");
			System.out.println("");
		} else {
			System.out.println("ファイルの削除が完了しました。");
			System.out.println("");
			System.out.println("");
		}

		System.out.println("続けますか？");
		System.out.println("1:続ける  それ以外:終了");
		str = utl.getInput();
		System.out.println("");
		if (!"1".equals(str)) {
			System.out.println("アプリを終了します");
			System.exit(0);
		}

	}

}
