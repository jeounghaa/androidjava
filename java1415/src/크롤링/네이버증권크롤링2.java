package 크롤링;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 네이버증권크롤링2 {

	public String[] crawl(String code) {
//		앤디포스 238090 / 카카오게임즈 293490 / 삼성전자 005930 / 한화솔루션 009830 / 초록뱀 047820
		
		Connection con = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=" + code);
		String[] list = null;
		try {
			Document doc = con.get();
			Elements list1 = doc.select("h2> a");
			String name = list1.get(0).text();
			System.out.println("회사이름: " + name);
			Elements list2 = doc.select("span.code");
			String code2 = list2.get(0).text();
			System.out.println("회사코드: " + code2);
			Elements list3 = doc.select("div.today");
//			System.out.println(list3);
			Elements list4 = list3.select(".blind");
//			System.out.println(list4);
			String now = list4.get(0).text(); // 현재가
			String dif = list4.get(1).text(); // 차이
			String per = list4.get(2).text(); // 증감비율
			
			System.out.println("현재가: " + now);
			System.out.println("어제와의 차이: " + dif);
			System.out.println("증감비율: " + per);
			
			Elements list5 = doc.select("td");
			Elements list6 = list5.select("span.blind");
			String high = list6.get(1).text(); // 고가
			String num = list6.get(3).text(); // 거래량
			System.out.println("고가: " + high);
			System.out.println("거래량: " + num);
			System.out.println("--------------");
			
			list =  new String[] {name, code, now, dif, per, high, num};
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
