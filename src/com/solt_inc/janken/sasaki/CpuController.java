package com.solt_inc.janken.sasaki;

import java.util.Random;

/**
 * CPUの攻撃パターン決定
 * @author n-sasaki
 *
 */
public class CpuController {

    /**
     *
     * @return CPUの攻撃パターン
     */
    public String controller() {
        String cpuPart = "";


        Random rnd = new Random();
        int rand = rnd.nextInt(2);

        //乱数によってCPUの攻撃パターンを決定
        switch (rand) {
        case 0:
            cpuPart = "グー";
            break;
        case 1:
            cpuPart = "パー";
            break;
        case 2:
            cpuPart = "チョキ";
            break;
        }

        return cpuPart;
    }

}
