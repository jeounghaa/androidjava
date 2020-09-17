package DB;

public class BookOrderVO {
	int paycode;
	int bookcode;
	int total;
	boolean paycheck;
	String usercode;
	String day;
	String payment;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPaycode() {
		return paycode;
	}

	public void setPaycode(int paycode) {
		this.paycode = paycode;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean getPaycheck() {
		return paycheck;
	}

	public void setPaycheck(boolean paycheck) {
		this.paycheck = paycheck;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

}
