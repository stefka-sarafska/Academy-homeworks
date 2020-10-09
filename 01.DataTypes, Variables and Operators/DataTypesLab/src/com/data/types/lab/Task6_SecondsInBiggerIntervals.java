package com.data.types.lab;

public class Task6_SecondsInBiggerIntervals {
	public static void main(String[] args) {
		
		int seconds = 1234567;
		final byte SECONDS_IN_ONE_MINUTE = 60;
		final short SECONDS_IN_ONE_HOUR = SECONDS_IN_ONE_MINUTE * 60;
		final int SECONDS_IN_ONE_DAY = SECONDS_IN_ONE_HOUR * 24;

		int secondsToDays = seconds / SECONDS_IN_ONE_DAY;
		int currSeconds = seconds - secondsToDays * SECONDS_IN_ONE_DAY;
		int secondsToHours = currSeconds / SECONDS_IN_ONE_HOUR;
		currSeconds -= secondsToHours * SECONDS_IN_ONE_HOUR;
		int secondsToMinutes = currSeconds / SECONDS_IN_ONE_MINUTE;
		currSeconds -= secondsToMinutes * SECONDS_IN_ONE_MINUTE;

		System.out.printf("%d days, %d hours, %d minutes,%d seconds", secondsToDays, secondsToHours, secondsToMinutes,
				currSeconds);

	}

}
