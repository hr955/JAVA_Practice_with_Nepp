package codes.datas;

import java.util.Calendar;

public class UserData {

	private String name;
	private String phoneNum;
	private int birthYear;

	@Override
	public String toString() {
		return String.format("%s(%s세) - %s", this.name, getKoreanAge(), this.phoneNum);
	}

	// 한국 나이 계산 메소드
	public int getKoreanAge() {
		// 올해의 나이 계산 -> 연도 값만 추출
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);

		return thisYear - this.birthYear + 1;
	}

	// 생성자 커스터마이징 -> 모든 데이터를 한번에 세팅
	public UserData(String name, String phoneNum, int birthYear) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthYear = birthYear;
	}

	// 정보은닉 -> getter/setter 메소드 활용
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}
