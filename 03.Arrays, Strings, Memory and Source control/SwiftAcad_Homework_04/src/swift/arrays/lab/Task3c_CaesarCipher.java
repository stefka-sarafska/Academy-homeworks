package swift.arrays.lab;

import java.util.Scanner;

public class Task3c_CaesarCipher {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		String inputToCode = sp.nextLine();
		String command = sp.nextLine();

		char[] arr = inputToCode.toCharArray();
		char[] codedArray = new char[arr.length];

		if (command.equals("encode")) {
			for (int i = 0; i < arr.length; i++) {
				if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {
					if (arr[i] == 'Z') {
						codedArray[i] = 'A';
					} else if (arr[i] == 'a') {
						codedArray[i] = 'a';

					} else {
						codedArray[i] = (char) (arr[i] + 1);
					}
				} else {
					codedArray[i] = arr[i];
				}
			}
			for (char ch : codedArray) {
				System.out.print(ch);
			}
		} else if (command.equals("decode")) {
			for (int i = 0; i < arr.length; i++) {
				if ((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) {
					if (arr[i] == 'Z') {
						codedArray[i] = 'A';
					} else if (arr[i] == 'a') {
						codedArray[i] = 'a';
					} else {
						codedArray[i] = (char) (arr[i] - 1);
					}
				} else {
					codedArray[i] = arr[i];
				}

			}
			for (char ch : codedArray) {
				System.out.print(ch);
			}
		}
	}

}
