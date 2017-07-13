package com.solt_inc.janken.sasaki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JankenGame {

    /**
     * ジャンケンゲーム
     * @param args
     *
     */
    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            CpuController sub = new CpuController();
            BattleResult battleResult = new BattleResult();
            ErrorCheck errorCheck = new ErrorCheck();
            String cpu;
            String result;
            boolean errFlag;

            for (;;) {

                String buf = "";
                buf = br.readLine();

                errFlag = errorCheck.inputCheck(buf);

                //グー・チョキ・パー以外の入力は処理終了
                if (errFlag == false) {
                    System.out.println("グー・チョキ・パーのいずれかを入力してください。");
                    continue;
                }
                cpu = sub.controller();

                result = battleResult.battle(cpu, buf);

                //あいこの場合は、もう一度入力
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
