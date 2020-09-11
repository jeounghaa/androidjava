package 컬렉션복습;

import java.util.ArrayList;

public class Account {

	public static void main(String[] args) {
		계좌 account1 = new 계좌("홍길동", "정기적금", 1000);
		계좌 account2 = new 계좌("김길동", "정기적금", 2000);
		계좌 account3 = new 계좌("박길동", "정기예금", 5000);
		계좌 account4 = new 계좌("이길동", "정기적금", 10000);
		계좌 account5 = new 계좌("최길동", "정기예금", 8000);
		
		ArrayList<계좌> list = new ArrayList<>();
		list.add(account1);
		list.add(account2);
		list.add(account3);
		list.add(account4);
		list.add(account5);
		
		계좌파일저장 file = new 계좌파일저장();
		file.save(list);
		
		
		
		
	}

}
