package com.solt_inc.janken.takagi;

public class JankenResult {
	public static final int RESULT_WIN = 0;
	public static final int RESULT_DRAW = 1;
	public static final int RESULT_LOSE = 2;

	private int result;
	private String message;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isWin() {
		return result == RESULT_WIN;
	}

	public boolean isLose() {
		return result == RESULT_LOSE;
	}

	public boolean isDraw() {
		return result == RESULT_DRAW;
	}

	public int getType(int type) {
		if (isDraw())
			return type;
		else if (isWin())
			return type == 2 ? 0 : (type + 1);
		else
			return type == 0 ? 2 : (type - 1);
	}

}
