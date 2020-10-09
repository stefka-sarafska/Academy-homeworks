package swift.date;

import java.util.Scanner;

public class SwiftDate {
	int year;
	byte month;
	byte day;

	public SwiftDate(int year, byte month, byte day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public boolean isLeapYear() {
		boolean isLeap = false;
		if ((this.year % 4 == 0 || this.year % 400 == 0) && this.year % 100 != 0) {
			isLeap = true;
		} else {
			isLeap = false;
		}
		return isLeap;
	}

	public boolean isLeapYear(int year) {
		boolean isLeap = false;
		if ((year % 4 == 0 || year % 400 == 0) && year % 100 != 0) {
			isLeap = true;
		} else {
			isLeap = false;
		}
		return isLeap;
	}

	public int getCentury(int year) {

		int century = year / 100 + 1;
		return century;
	}

	public int getDaysDifference(SwiftDate date) {
		int days1 = 0;
		int days2 = 0;
		for (int i = 1; i < this.getYear(); i++) {
			if (this.isLeapYear(i)) {
				days1 += 366;
			} else {
				days1 += 365;
			}
		}
		for (int i = 1; i < this.getMonth(); i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				days1 += 31;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				days1 += 30;
			} else if (i == 2) {
				if (this.isLeapYear()) {
					days1 += 29;
				} else {
					days1 += 28;
				}
			}
		}
		days1 += this.getDay();
		for (int i = 1; i < date.getYear(); i++) {
			if (date.isLeapYear(i)) {
				days2 += 366;
			} else {
				days2 += 365;
			}
		}
		for (int i = 1; i < date.getMonth(); i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				days2 += 31;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				days2 += 30;
			} else if (i == 2) {
				if (date.isLeapYear()) {
					days2 += 29;
				} else {
					days2 += 28;
				}
			}
		}
		days2 += date.getDay();
		return Math.abs(days1 - days2);
	}

	public void printInfo(SwiftDate date) {
		if (date.getDay() < 10 && date.getMonth() < 10) {
			System.out.printf("%d 0%d 0%d - %d century.", date.getYear(), date.getMonth(), date.getDay(),
					date.getCentury(date.getYear()));
			if (date.isLeapYear(date.getYear())) {
				System.out.println(" It is LEAP year.");
			} else {
				System.out.println();
			}

		} else if (date.getMonth() < 10) {
			System.out.printf("%d 0%d %d - %d century.", date.getYear(), date.getMonth(), date.getDay(),
					date.getCentury(date.getYear()));
			if (date.isLeapYear(date.getYear())) {
				System.out.println(" It is LEAP year.");
			} else {
				System.out.println();
			}
		} else if (date.getDay() < 10) {

			System.out.printf("%d %d 0%d - %d century.", date.getYear(), date.getMonth(), date.getDay(),
					date.getCentury(date.getYear()));
			if (date.isLeapYear(date.getYear())) {
				System.out.println(" It is LEAP year.");
			} else {
				System.out.println();
			}
		} else {

			System.out.printf("%d %d %d - %d century.", date.getYear(), date.getMonth(), date.getDay(),
					date.getCentury(date.getYear()));

			if (date.isLeapYear(date.getYear())) {
				System.out.println(" It is LEAP year.");
			} else {
				System.out.println();
			}
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		this.month = month;
	}

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);

		int year = sp.nextShort();
		byte month = sp.nextByte();
		byte day = sp.nextByte();

		int year1 = sp.nextShort();
		byte month1 = sp.nextByte();
		byte day1 = sp.nextByte();
		sp.close();

		SwiftDate date = new SwiftDate(year, month, day);
		SwiftDate date1 = new SwiftDate(year1, month1, day1);
		System.out.println(date.getDaysDifference(date1));
		date.printInfo(date);
		date1.printInfo(date1);
	}
}
