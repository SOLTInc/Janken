package com.solt_inc.janken.takagi.level.easy;

import java.util.Random;

import com.solt_inc.janken.takagi.JankenBot;
import com.solt_inc.janken.takagi.JankenResult;

public class EasyJankenBot implements JankenBot {

	@Override
	public JankenResult action(int type) {
		JankenResult res = new JankenResult();
		Random random = new Random();
		// 6回に3回勝ち、2回アイコ、1回負けの確率にする
		int val = random.nextInt(6);
		res.setResult(val < 3 ? JankenResult.RESULT_WIN
				: (val < 5 ? JankenResult.RESULT_DRAW
						: JankenResult.RESULT_LOSE));
		res.setMessage(res.isWin() ? "負けたー" : (res.isLose() ? "勝ったぞ！" : "あ"));
		return res;
	}

}
