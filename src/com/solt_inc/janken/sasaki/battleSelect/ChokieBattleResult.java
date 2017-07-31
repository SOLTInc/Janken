package com.solt_inc.janken.sasaki.battleSelect;

import com.solt_inc.janken.sasaki.BattleResult;

public class ChokieBattleResult  extends BattleResult{

    @Override
    public String battleSub(String cpuPart) {
        String result = "";

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

        return result;
    }
}
