package com.solt_inc.janken.takagi.level.normal;

import java.util.Random;

import com.solt_inc.janken.takagi.JankenBot;
import com.solt_inc.janken.takagi.JankenResult;

public class NormalJankenBot implements JankenBot {

	@Override
	public JankenResult action(int type) {
		JankenResult res = new JankenResult();
		Random random = new Random();
		// 結果は完全乱数で設定
		int val = random.nextInt(3);
		res.setResult(val);
		res.setMessage(res.isWin() ? "君の勝ちだ！"
				: (res.isLose() ? "残念だったね！" : "お"));
		return res;
	}

}
