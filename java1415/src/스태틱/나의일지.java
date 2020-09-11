package 스태틱;


public class 나의일지 {

	public static void main(String[] args) {
		Day day1 = new Day("자바공부", 10, "신촌");
		System.out.println(Day.count + "개 생성됨 ");
		System.out.println("총 " + Day.sum + "시간");
		Day day2 = new Day("운동", 6, "공원");
		System.out.println(Day.count + "개 생성됨 ");
		System.out.println("총 " + Day.sum + "시간");
		Day day3 = new Day("여행", 15, "강원도");
		System.out.println(Day.count + "개 생성됨 ");
		System.out.println("총 " + Day.sum + "시간");
		
		System.out.println("-----------------------------------------");
//		System.out.println("평균시간은 " + Day.sum/Day.count);
		System.out.println("평균시간은 " + day1.getAvg() + "시간");
		System.out.println("회사이름은 " + Day.getName());
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(day3);
	}

}
