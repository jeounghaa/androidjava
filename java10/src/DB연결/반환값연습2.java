package DB연결;

import java.util.Date;
import java.util.Random;

public class 반환값연습2 {
	public static void main(String[] args) {
		String data = "나는 자바 프로그래머 정말";
		String[] dataset = data.split(" ");
		
		System.out.println(dataset.length);
		for (String s : dataset) {
			System.out.println(s);
		}
		System.out.println("--------------");
		String data2 = "02-844-1234";
		String[] dataset2 = data2.split("-");
		System.out.println(dataset2.length);
		for (String s : dataset2) {
			System.out.println(s);
		}
		
	}
	
}
