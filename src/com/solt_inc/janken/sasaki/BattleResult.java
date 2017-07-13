package com.solt_inc.janken.sasaki;

public class BattleResult {

    public String battle(String cpuPart, String buf) {
        String result = "";

        if (buf.equals("グー")) {
            switch (cpuPart) {
            case "グー":
                result = "あいこ";
                break;
            case "パー":
                result = "敗北";
                break;
            case "チョキ":
                result = "勝利";
                break;
            }
        }

        if (buf.equals("チョキ")) {
            switch (cpuPart) {
            case "グー":
                result = "敗北";
                break;
            case "パー":
                result = "勝利";
                break;
            case "チョキ":
                result = "あいこ";
                break;
            }
        }

        if (buf.equals("パー")) {
            switch (cpuPart) {
            case "グー":
                result = "勝利";
                break;
            case "パー":
                result = "あいこ";
                break;
            case "チョキ":
                result = "敗北";
                break;
            }
        }

        return "あなた：" + buf + "  CPU：" + cpuPart + "  "+ result + "です。";
    }
}
