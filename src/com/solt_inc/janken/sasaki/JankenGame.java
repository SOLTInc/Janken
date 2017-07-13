package com.solt_inc.janken.sasaki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.solt_inc.janken.sasaki.battleSelect.ChokieBattleResult;
import com.solt_inc.janken.sasaki.battleSelect.GooBattleResult;
import com.solt_inc.janken.sasaki.battleSelect.ParBattleResult;

public class JankenGame {

	/**
	 * ジャンケンゲーム
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			CpuController sub = new CpuController();

			ErrorCheck errorCheck = new ErrorCheck();
			String cpu;
			String result;
			boolean errFlag;

			for (;;) {

				String buf = "";
				buf = br.readLine();

				errFlag = errorCheck.inputCheck(buf);

				// グー・チョキ・パー以外の入力は処理終了
				if (errFlag == false) {
					System.out.println("グー・チョキ・パーのいずれかを入力してください。");
					continue;
				}
				cpu = sub.controller();

				BattleResult battleResult;

				if (buf.equals("グー")) {
					battleResult = new GooBattleResult();
				} else if (buf.equals("チョキ")) {
					battleResult = new ChokieBattleResult();
				} else if (buf.equals("パー")) {
					battleResult = new ParBattleResult();
				} else {
					System.out.println("グー・チョキ・パーのいずれかを入力してください。");
					continue;
				}
				result = battleResult.battle(cpu, buf);

				// あいこの場合は、もう一度入力
				if (cpu.equals(buf)) {
					System.out.println(result);
					continue;
				} else {
					System.out.println(result);
					continue;
				}
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
