package 크롤링;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 네이버증권크롤링 {

	public static void main(String[] args) {
		Connection con = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=293490");

		try {
			Document doc = con.get();
			Elements list = doc.select("h2> a");
			String name = list.get(0).text();
			System.out.println("회사이름: " + name);
			Elements list2 = doc.select("span.code");
			String code = list2.get(0).text();
			System.out.println("회사코드: " + code);
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
			String high = list6.get(1).text();
			System.out.println("고가: " + high);
			String num = list6.get(3).text();
			System.out.println("거래량: " + num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
