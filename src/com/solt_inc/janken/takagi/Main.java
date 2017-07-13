package com.solt_inc.janken.takagi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.solt_inc.janken.takagi.level.easy.EasyJankenBot;
import com.solt_inc.janken.takagi.level.hard.HardJankenBot;
import com.solt_inc.janken.takagi.level.normal.NormalJankenBot;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader stdReader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out
				.print("Bot: Eモードを選んでね！　(E : easy, N : Normal, H : hard, Empty : 終了)　＞　");
		String line;
		int cnt = 0;
		JankenBot bot = null;
		int retryFlg = 0;
		while ((line = stdReader.readLine()) != null) { // ユーザの一行入力を待つ
			line = line.toUpperCase();
			if (line.equals(""))
				break;
			if (cnt == 0) {
				bot = createBotInstance(line);
				if (bot == null)
					break;
				System.out.print("Bot: 最初は・・　(G : ぐー, C : ちょき, P : ぱー)　＞　");
			} else {
				if (retryFlg == 1) {
					retryFlg = 0;
					if (line.equals("Y")) {
						System.out
								.print("Bot: 最初は・・　(G : ぐー, C : ちょき, P : ぱー)　＞　");
						continue;
					} else {
						break;
					}
				}
				int type = toType(line);
				if (type == -1) {
					System.out
							.print("Bot: あれ？ちゃんと出してよ！　(G : ぐー, C : ちょき, P : ぱー)　＞　");
				} else {
					JankenResult result = bot.action(type);
					if (result.isDraw()) {
						System.out.println(print(result, type) + " Bot: "
								+ result.getMessage());
						System.out
								.print("Bot: あいこで　(G : ぐー, C : ちょき, P : ぱー)　＞︎　");
					} else {
						System.out.println(print(result, type) + " Bot: "
								+ result.getMessage());
						System.out
								.print("\n"
										+ (result.isWin() ? "You Win! "
												: "You Lose.. ")
										+ " retry? (Y : yes, N : no)　＞　");
						retryFlg = 1;
					}
				}
			}
			cnt++;
		}
		stdReader.close();
		System.out.println("Thanks! バイバイ!");
	}

	private static String print(JankenResult result, int type) {
		return "[You:" + typeTo(type) + " Bot:" + typeTo(result.getType(type))
				+ "]";
	}

	private static String typeTo(int type) {
		if (type == JankenBot.TYPE_GOO) {
			return "👊";
		} else if (type == JankenBot.TYPE_CHOKI) {
			return "✌️";
		} else if (type == JankenBot.TYPE_PAA) {
			return "✋";
		} else {
			throw new UnsupportedOperationException("inner error");
		}
	}

	private static int toType(String line) {
		if (line.equals("G"))
			return JankenBot.TYPE_GOO;
		if (line.equals("C"))
			return JankenBot.TYPE_CHOKI;
		if (line.equals("P"))
			return JankenBot.TYPE_PAA;
		return -1;
	}

	private static JankenBot createBotInstance(String line) {
		if (line.equals("E"))
			return new EasyJankenBot();
		if (line.equals("N"))
			return new NormalJankenBot();
		if (line.equals("H"))
			return new HardJankenBot();
		return null;
	}
}
