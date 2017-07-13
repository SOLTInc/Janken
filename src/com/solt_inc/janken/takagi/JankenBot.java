package com.solt_inc.janken.takagi;

public interface JankenBot {
	int TYPE_GOO = 0;
	int TYPE_CHOKI = 1;
	int TYPE_PAA = 2;

	JankenResult action(int type);
}
