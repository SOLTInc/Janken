package battleSelect;

public class ChokieBattleResult {

    public String battle(String cpuPart) {
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
