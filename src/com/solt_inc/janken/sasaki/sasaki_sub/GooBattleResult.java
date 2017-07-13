package battleSelect;

public class GooBattleResult {

    public String battle(String cpuPart) {
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
