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
				for (int input : inputNumbers) {
					if (input == inputNum) {
						isDuplOk = false;
						break;
					}
				}

				// 입력값의 범위가 0<input<45 이고, 중복이 아닐 때
				if (isRangeOk && isDuplOk) {
					inputNumbers[i] = inputNum;
					break;
				} else {
					if (!isRangeOk) {
						// 범위 검사 탈락
						System.out.print("1~45의 숫자만 입력 가능합니다. ");
					} else {
						// 중복 검사 탈락
						System.out.print("이미 입력한 숫자입니다. ");
					}
					System.out.println("다시 입력해주세요.");
				}
			}
		}
		scanner.close();

		// 입력 완료 => 당첨번호(난수) 6개 생성
		int[] winNumbers = new int[6];

		for (int i = 0; i < winNumbers.length; i++) {
			while (true) {
				// 1~45 사이의 난수 생성

				// 범위검사 필요X

				// Math.random = 0.0 ~ 0.99999999999... 사이의 랜던값을 추출
				// Math.random * 45 = 0.0 ~ 44.99999999999... 사이의 랜던값을 추출

				// 1 ~ 45 사이의 난수 발생
				int randomNum = (int) (Math.random() * 45) + 1;

				// 중복검사는 필요
				boolean isDuplOk = true;

				for (int winNum : winNumbers) {
					if (winNum == randomNum) {
						// 중복 발견
						isDuplOk = false;
						break;
					}
				}

				if (isDuplOk) {
					winNumbers[i] = randomNum;
					break;
				}
			}
		}

		// 당첨번호 출력
		for (int winNum : winNumbers) {
			System.out.print(winNum + " ");
		}

		// 입력값과 당첨번호를 비교하여 등수 판별

		int correctNumCnt = 0; // 내가 맞춘 번호 개수

		for (int myNum : inputNumbers) {
			// 내가 선택한 번호를 하나 뽑아 당첨번호와 비교
			for (int winNum : winNumbers) {
				// 내 번호와 당첨번호가 일치하는지 비교
				if (myNum == winNum) {
					correctNumCnt++;
				}
			}
		}

		// 맞춘 번호의 개수에 따라 등수 출력
		if (correctNumCnt == 6) {
			System.out.println("1등");
		} else if (correctNumCnt == 5) {
			System.out.println("3등");
		} else if (correctNumCnt == 4) {
			System.out.println("4등");
		} else if (correctNumCnt == 3) {
			System.out.println("5등");
		} else {
			System.out.println("낙첨");
		}

	}
}
