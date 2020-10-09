package swift.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class Task2f_LargestSumOfKSubsequence {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
        int n = sp.nextInt();
        int k = sp.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sp.nextInt();
        }
        int maxSumOfNumbers=Integer.MIN_VALUE;
        int[] maxNumbersArray=new int[k];
        for (int i = 0; i < numbers.length; i++) {
            int sumOfNumbers = 0;
            if(i==numbers.length-1){
                break;
            }
                int[] kRangeOfNumbers = Arrays.copyOfRange(numbers, i, k + i);
                for (int j = 0; j < kRangeOfNumbers.length; j++) {
                    sumOfNumbers += kRangeOfNumbers[j];

                }
                if (sumOfNumbers > maxSumOfNumbers) {
                    maxSumOfNumbers = sumOfNumbers;
                    maxNumbersArray = kRangeOfNumbers;
                }
            }

        for(int num:maxNumbersArray) {
            System.out.printf("%d ",num);
        }
	}

}
