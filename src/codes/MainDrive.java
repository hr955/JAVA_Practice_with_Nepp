package codes;

import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {

		printMenu();

	}

	static void printMenu() {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("========전화번호부========");
			System.out.println("1. 전화번호 추가");
			System.out.println("2. 전화번호 목록 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("=======================");
			System.out.print("메뉴 입력 : ");

			int inputMenu = scanner.nextInt();

			if (inputMenu == 0) {
				// 프로그램 종료 -> while문 종료
				break;
			} else if (inputMenu == 1) {
				// 전화번호 추가
				addPhoneNum();

			} else if (inputMenu == 2) {
				// 전화번호 목록 조회
				showAllPhoneNum();

			} else {
				System.out.println("잘못된 입력입니다. 메뉴로 돌아갑니다..");

				// 2초간 프로그램 정지 -> 메뉴로
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}

	// 전화번호 추가 관련 코드 함수
	static void addPhoneNum() {
		// 이름, 전화번호, 출생년도를 순서대로 입력
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String name = scanner.next();

		System.out.print("전화번호 입력 : ");
		String phoneNum = scanner.next();

		System.out.print("출생년도 입력 : ");
		int birthYear = scanner.nextInt();

		// 정보들을 한줄로 모아주기 -> "이름, 전화번호, 출생년도" 형태
		String content = String.format("%s,%s,%d", name, phoneNum, birthYear);

		// 가공된 String을 myPhoneBook.csv 파일에 저장
		savePhoneNumToFile(content);

	}

	// 가공된 String을 파일에 추가하는 함수
	static void savePhoneNumToFile(String content) {

	}

	// 전화번호 목록 조회 함수
	static void showAllPhoneNum() {

	}

}
