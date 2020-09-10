package 크롤링;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 네이버메인크롤링 {

	public static void main(String[] args) {
		// 크롤링
		// >> 웹사이트에서 정보를 가지고 오는 것
		// 단순: 스크랩핑
		// 단순+@: 크롤링
		// 크롤링 순서
		// 1. 사이트 연결
		// 2. 해당 페이지 다운로드(html)
		// 3. 원하는 위치의 정보를 추출
		Connection con = Jsoup.connect("https://www.naver.com/");
		System.out.println("1. 사이트 연결 성공");

		try {
			Document doc = con.get();
			System.out.println("2. 해당 페이지 다운로드 성공"); // index.html
			System.out.println("---------------------");
//			System.out.println(doc);
//			System.out.println(doc.select("a.nav"));
			System.out.println("3. 원하는 위치의 정보 추출 성공");
			Elements list = doc.select("a.nav");
			// Elements == ArrayList의 상속
//			Element tag = list.get(0);
//			System.out.println(tag);
//			String text = tag.text();
//			System.out.println(text);
			for (int i = 0; i < list.size(); i++) {
				Element tags = list.get(i);
				String texts = tags.text();
				System.out.print(texts + "  ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
