package 컬렉션복습;

import java.io.FileWriter;
import java.util.ArrayList;

public class 계좌파일저장 {
	public void save(ArrayList<계좌> list) {
		for (int i = 0; i < list.size(); i++) {
			try {
				계좌 account = list.get(i);
//				System.out.println(list.size());
				FileWriter file = new FileWriter(account.name + ".txt");
				file.append(account.name);
				file.append(account.field);
				file.append(account.name);
				file.close();
			} catch (Exception e) {
				System.out.println("파일저장에러");
				e.printStackTrace();
			}
		}
		
	}
}
