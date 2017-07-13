package com.solt_inc.janken.sasaki;

public class ErrorCheck {

    /**
     * 入力値のチェック
     * @param buf
     * @return エラーフラグ
     */
    public boolean inputCheck(String buf) {

        boolean errFlag;
        errFlag = false;

        switch (buf) {
        case "グー":
            errFlag = true;
            break;
        case "パー":
            errFlag = true;
            break;
        case "チョキ":
            errFlag = true;
            break;
        }

        return errFlag;
    }
}
