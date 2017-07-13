package battleSelect;

public class ParBattleResult {

    public String battle(String cpuPart) {
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
