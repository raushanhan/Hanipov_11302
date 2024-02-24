package ru.kpfu.itis.group302.log;

import ru.kpfu.itis.group302.players.*;

public class Log {
	
	public static void out(Object x) {
		System.out.println(x);
	}
	
	public static void logResult(boolean result, AbstractPlayer p) {
		if (result) {
			Log.out("Succes, " + p.getName() + "'s hp is " + p.getHP() + ".");
		} else {
			Log.out("Missed");
		}
	}
	
}