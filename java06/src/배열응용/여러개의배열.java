package 배열응용;


public class 여러개의배열 {

	public static void main(String[] args) {
		String[] fam = {"아버지", "어머니", "형", "나", "동생"};
		int[] age = {100, 88, 33, 24, 10};
		double[] hei = {177.5, 152.2, 190.3, 167.7, 155.3};
		
		System.out.println("우리집 식구 정리");
		System.out.println("----------------");
		System.out.println("이름     나이      키");
		for (int i = 0; i < fam.length; i++) {
			System.out.print(fam[i] + "  ");
			System.out.print(age[i] + "  ");
			System.out.print(hei[i] + "  " + "\n");
		}
		
	}

}
