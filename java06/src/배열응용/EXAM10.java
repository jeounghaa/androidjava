package 배열응용;

public class EXAM10 {

	public static void main(String[] args) {
		String[] sub = {"국어", "수학", "과학", "컴퓨터", "영어"};
		int[] one = {100, 99, 77, 87, 66};
		int[] two = one.clone();
		
		int count = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		String result = "";
		
		// 1학기 점수 출력
		System.out.println("1학기 과목 점수");
		for (int i : one) {
			System.out.print(i + " ");
			sum1 += i;
		}
		System.out.println();
		
		// 점수 변경
		two[2] = 44;
		two[4] = 55;
		
		// 2학기 점수 출력
		System.out.println("2학기 과목 점수");
		for (int i : two) {
			System.out.print(i + " ");
			sum2 += i;
		}
		System.out.println();
		
		// 1학기 2학기 점수 비교해서 출력하고싶은 값 result에 넣음
		if (sum1> sum2) {
			result = "1학기가 2학기보다 높습니다. (1학기: " + sum1/one.length 
					+ ", 2학기: " + sum2/two.length + ")";
		} else if (sum1 < sum2) {
			result = "2학기가 1학기보다 높습니다. (1학기: " + sum1/one.length 
					+ ", 2학기: " + sum2/two.length + ")";
		} else {
			result = "1학기 2학기 동일합니다. (1학기: " + sum1/one.length 
					+ ", 2학기: " + sum2/two.length + ")";
		}
		
		for (int i = 0; i < one.length; i++) {
			// 1학기와 2학기 성적이 다른 과목 비교
			// 다르면 count에 +1
			if (one[i] != two[i]) {
				count++;
				System.out.println("점수가 변경된 과목: " + sub[i]);
			}
		}
		
		System.out.println("점수가 변경된 과목의 수는 " + count + "과목");
		System.out.println(result);
		
	}// main end

}
