package com.solt_inc.janken.sasaki.battleSelect;

import com.solt_inc.janken.sasaki.BattleResult;

public class GooBattleResult  extends BattleResult{

    @Override
    public String battleSub(String cpuPart) {
        String result = "";

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

        return result;
    }
}
