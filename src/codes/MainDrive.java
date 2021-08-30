package codes;

import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {
		// github upload
		
		Scanner scanner = new Scanner(System.in);

		// 입력한 6개의 숫자를 저장할 배열
		int[] inputNumbers = new int[6];

		System.out.print("6개의 숫자 입력 : ");
		// 사용자에게 6개의 숫자를 입력받음
		for (int i = 0; i < inputNumbers.length; i++) {
			inputNumbers[i] = scanner.nextInt();
		}
		
		scanner.close();
	}

}
