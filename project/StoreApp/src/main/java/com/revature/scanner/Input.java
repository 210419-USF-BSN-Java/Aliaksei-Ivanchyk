package com.revature.scanner;

import java.util.Scanner;

public final class Input {
	
	private static Scanner scanner;

	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
}
