package com.solt_inc.janken.kida.slot;

import com.solt_inc.janken.kida.base.BaseService;
import com.solt_inc.janken.kida.common.Util;
import com.solt_inc.janken.kida.data.Bean;

public class Slot extends BaseService {

	private Util ユーティリティ;
	private スロットユーティリティ スロ;

	protected boolean chk(){
		if (Bean.getsCoin() == 0) {
			System.out.println("現在のコイン枚数:"+Bean.getsCoin()+"枚");
			System.out.println("賭けられるコインがありません。どこかで稼いできて下さい。");
			System.out.println("");
			return false;
		}
		return true;
	}

	protected void init(){
		ユーティリティ = new Util();
		スロ = new スロットユーティリティ();
	}

	@Override
	protected boolean body() {

		System.out.println("現在のコイン枚数:"+Bean.getsCoin()+"枚");
		System.out.println("コインを賭けて下さい（最大10枚）   98:配当表  99:終了");
		System.out.println("");


		boolean コイン入力チェック = false;
		int コイン枚数 = 0;

		while (!コイン入力チェック) {
			String 入力値 = ユーティリティ.getInput();
			コイン枚数 = ユーティリティ.exchangeInt(入力値);

			if (コイン枚数 == 99) {
				System.out.println("スロットを終了します");
				System.out.println("");
				return false;
			} else if (コイン枚数 == 98) {
				スロ.配当表();
				System.out.println("現在のコイン枚数:"+Bean.getsCoin()+"枚");
				System.out.println("コインを賭けて下さい（最大10枚）   98:配当表  99:終了");
				System.out.println("");
			} else if (コイン枚数 >= 1 && コイン枚数 <= 10) {

				//コインが足りているかチェック
				if (Bean.getsCoin() - コイン枚数 < 0 ) {
					System.out.println("現在のコイン枚数:"+Bean.getsCoin()+"枚");
					System.out.println("コインが足りません もう一度賭けて下さい（最大10枚）   98:配当表  99:終了");
					System.out.println("");
					コイン入力チェック = false;
				} else {
					// 足りている場合、コインを引く
					Bean.coinMinus(コイン枚数);
					コイン入力チェック = true;
				}

			} else {
				System.out.println("現在のコイン枚数:"+Bean.getsCoin()+"枚");
				System.out.println("1枚以上10枚以内で賭けて下さい   98:配当表  99:終了");
				System.out.println("");
			}
		}

		// スロットの目を出す
		int 左 = (int) (Math.random() * 100)+1; // 1から100までの乱数
		int 中 = (int) (Math.random() * 100)+1; // 1から100までの乱数
		int 右 = (int) (Math.random() * 100)+1; // 1から100までの乱数

		String 表示用左 = スロ.表示用文字作成(左);
		String 表示用中 = スロ.表示用文字作成(中);
		String 表示用右 = スロ.表示用文字作成(右);

		int 配当結果 = スロ.配当コイン(表示用左, 表示用中, 表示用右, コイン枚数);

		try {
			System.out.println("");
			System.out.print(表示用左+" ");
			Thread.sleep(500);
			System.out.print(表示用中+" ");
			Thread.sleep(500);
			System.out.println(表示用右);
			System.out.println("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 配当結果計計算結果が0でない場合、勝ちのため、通知する
		if (配当結果 != 0) {
			System.out.println("おめでとう! "+配当結果+" 枚当たり");
			System.out.println("");
			Bean.coinPlus(配当結果);
		}
		return true;
	}
}
