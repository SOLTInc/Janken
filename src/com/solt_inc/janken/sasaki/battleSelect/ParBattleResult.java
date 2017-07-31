package com.solt_inc.janken.sasaki.battleSelect;

import com.solt_inc.janken.sasaki.BattleResult;

public class ParBattleResult extends BattleResult{

    @Override
    public String battleSub(String cpuPart) {
        String result = "";

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

        return result;
    }
}
