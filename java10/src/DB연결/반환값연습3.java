package DB연결;

import java.util.Date;
import java.util.Random;

public class 반환값연습3 {
	public static void main(String[] args) {
		String data = "A1가";
		char[] dataset = data.toCharArray();
		for (char s : dataset) {
			System.out.println(s);
		}
		System.out.println("--------------");
		System.out.println(dataset[0]);
	}
	
}
