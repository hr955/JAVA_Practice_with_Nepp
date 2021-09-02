package codes;

import java.io.*;
import java.util.*;

import codes.datas.UserData;

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

		// 가공된 String을 myPhoneBook.csv 파일에 저장
		File myFile = new File("myPhoneBook.csv");

		try {
			// 지정된 파일에, 데이터 작성을 해주는 클래스 (FileWriter) -> 예외처리 필요
			FileWriter fw = new FileWriter(myFile, true);

			// FileWriter는 2byte씩 데이터 처리 -> 한글자씩
			// 한문장씩 입력하기 위해 보조도구 활용 (BufferedWriter)
			BufferedWriter bw = new BufferedWriter(fw);

			// 보조도구로 저장할 내용을 한번에 한줄 저장
			bw.append(content);
			// 줄바꾸기
			bw.newLine();

			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 전화번호 목록 조회 함수
	static void showAllPhoneNum() {
		// ArrayList에 사용자뎅녀 UserData목록을 담아주기
		// UserData클래스 추가

		List<UserData> userList = new ArrayList<>();

		// 파일을 읽으면서 -> 읽어온정볼르 -> UserData로 변환 -> userList에 추가
		addUsersByFile(userList);

		// userList목록에 들어있는 항목들을 출력
		for (UserData user : userList) {
			System.out.println(user);
		}

	}

	static void addUsersByFile(List<UserData> list) {
		// 목록을 담아주고싶은 List를 받아 추가

		// 파일에 적힌 내용을 list에 추가
		File myFile = new File("myPhoneBook.csv");

		try {
			// 지정된 파일을 (2byte - 한글자씩) 읽어주는 클래스 -> 예외처리 필요
			FileReader fr = new FileReader(myFile);
			// 한문장씩 String으로 뭉쳐서 읽어오게 하는 보조도구 (BufferedReader)
			BufferedReader br = new BufferedReader(fr);

			// br이 한줄씩 읽어오게. 몇줄이나 있을지 알 수 없다. -> 무한반복+break;
			while (true) {
				// 한줄 읽어와서 변수에 담기 -> 예외처리 필요 (이미 try-catch안에서 작업중 : add catch)
				String line = br.readLine();

				// 읽어온 line이 null이면, 더이상 읽어올 내용이 없다.
				if (line == null) {
					// while 종료
					break;
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("전화번호가 비어있습니다.");
			System.out.println("전화번호부 파일이 생성되지 않았습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일은 잘 불러왔지만, 내용을 읽어올 때 손상된 부분이 있습니다.");
			e.printStackTrace();
		}

	}

}
