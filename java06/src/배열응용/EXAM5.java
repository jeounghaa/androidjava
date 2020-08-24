package 배열응용;



public class EXAM5 {

	public static void main(String[] args) {
		int[] num = {66, 77, 88, 99};
		int max = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		System.out.println("최대값은 " + max + "입니다.");
	}

}
