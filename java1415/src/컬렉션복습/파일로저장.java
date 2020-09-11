package 컬렉션복습;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class 파일로저장 {

	public void save(ArrayList<Day> list) {
		// 외부에서 데이터를 받아서 파일로 저장
		// list를 받아옴
		System.out.println(list.size() + "일치가 넘어왔음");
		for (int i = 0; i < list.size(); i++) {
			// 컨테이너 역할인 list에서 하나씩 꺼내는 부분
			Day day = list.get(i);
			System.out.println("전달된 일과: " + day);
			System.out.println("---------------------------------------");
			// 파일로 저장할 예정 >> 예외처리
			try {
				// 파일을 만들어서 저장하는 부품써야함
				FileWriter w = new FileWriter(i + ".txt");
				w.write(day.doing + "\n");
				w.write(day.time + "\n");
				w.write(day.location + "\n");
				w.close();
			} catch (Exception e) {
				// try내에 있는 코드에서 에러가 발생했을 때, 대응처리 내용을 써줌
				System.out.println("파일로 저장하다가 에러가 발생함");
			}
		}
	}

}
