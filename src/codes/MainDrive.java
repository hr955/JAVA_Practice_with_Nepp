package codes;

import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {
		// github upload

		Scanner scanner = new Scanner(System.in);

		// 입력한 6개의 숫자를 저장할 배열
		int[] inputNumbers = new int[6];

		// 사용자에게 6개의 숫자를 입력받음
		for (int i = 0; i < inputNumbers.length; i++) {

			// 각 자리의 숫자 입력은, 제대로 입력할 때까지 반복.
			// 반복 횟수 불명확.

			while (true) {
				System.out.print((i + 1) + "번째 숫자 입력 : ");
				int inputNum = scanner.nextInt();

				// 숫자범위 검사 변수
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45); 

				// 중복 검사 변수
				boolean isDuplOk = true; 

				// 입력값의 범위가 0<input<45 이고, 중복이 아닐 때
				if (isRangeOk && isDuplOk) {
					inputNumbers[i] = inputNum;
					break;
				} else {
					System.out.print("잘못된 숫자입니다. 다시 입력해주세요.");
				}
			}
		}
		scanner.close();
	}

}
