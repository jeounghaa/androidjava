package 배열응용;



public class EXAM6 {

	public static void main(String[] args) {
		// 66과 99의 위치를 변경
		int[] num = {66, 77, 88, 99};
		
		int x = num[0];
		
		num[0] = num[3];
		num[3] = x;
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
	}

}
