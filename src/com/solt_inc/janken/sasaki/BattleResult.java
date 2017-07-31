package com.solt_inc.janken.sasaki;

public abstract class BattleResult {

    public String battle(String cpuPart, String buf) {
        String result = battleSub(cpuPart);



        return "あなた：" + buf + "  CPU：" + cpuPart + "  " + result + "です。";
    }

    public abstract String battleSub(String cpuPart);
}
