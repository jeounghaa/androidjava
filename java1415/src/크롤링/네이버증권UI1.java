package 크롤링;

import java.io.FileWriter;

public class 네이버증권UI1 {

	public static void main(String[] args) {
		// 주식코드
		String[] codes = {"238090", "293490", "005930", "009830", "047820"};
		// 주식이름
//		String[] names = {"앤디포스", "카카오게임즈", "삼성전자", "한화솔루션", "초록뱀"};
		
		네이버증권크롤링2 naver = new 네이버증권크롤링2();
		// codes를 하나씩 빼서 크롤링
		for (int i = 0; i < codes.length; i++) {
			String[] list = naver.crawl(codes[i]);
			try {
				FileWriter file = new FileWriter(list[0] + ".txt");
				file.write("회사이름: " + list[0] + "\n"); // 이름
				file.write("회사코드: " + list[1] + "\n"); // 코드
				file.write("현재가: " + list[2] + "\n"); // 현재가
				file.write("어제와의 차이: " + list[3] + "\n"); // 어제와의 차이
				file.write("증감비율: " + list[4] + "\n"); // 증감비율
				file.write("고가: " + list[5] + "\n"); // 고가
				file.write("거래량: " + list[6] + "\n"); // 거래량
				file.close();
			} catch (Exception e) {
				System.out.println("파일 저장 에러");
			}
		}
		
	}

}
