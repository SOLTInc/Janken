package com.solt_inc.janken.takagi.level.hard;

import java.util.Stack;

import com.solt_inc.janken.takagi.JankenBot;
import com.solt_inc.janken.takagi.JankenResult;

public class HardJankenBot implements JankenBot {

	private Stack<Integer> typeStack = new Stack<Integer>();

	@Override
	public JankenResult action(int type) {
		JankenResult res = new JankenResult();
		// 相手の手を見て、初回は必ずアイコ、ぐー、チョキ、パーの順番に沿って出して、４回目に前と同じ手を出したら勝てるように動作する。他は全部負け。
		if (typeStack.isEmpty()) {
			res.setResult(JankenResult.RESULT_DRAW);
		} else if (typeStack.size() < 3) {
			int answer = typeStack.peek() + 1;
			if (answer == 3)
				answer = 0;
			if (type == answer) {
				res.setResult(JankenResult.RESULT_DRAW);
			} else {
				res.setResult(JankenResult.RESULT_LOSE);
			}
		} else if (typeStack.size() == 3) {
			// 勝負の回
			if (type == typeStack.peek()) {
				res.setResult(JankenResult.RESULT_WIN);
			} else {
				res.setResult(JankenResult.RESULT_LOSE);
			}
		}
		if (res.isWin()) {
			res.setMessage("な、なんだと！？");
		} else if (res.isLose()) {
			res.setMessage("ふ、雑魚か・・");
		} else if (typeStack.size() == 0) {
			res.setMessage("お");
		} else if (typeStack.size() == 1) {
			res.setMessage("むむ？");
		} else if (typeStack.size() == 2) {
			res.setMessage("まさか");
		} else {
			throw new UnsupportedOperationException("inner error");
		}
		typeStack.push(type);
		return res;
	}

}
