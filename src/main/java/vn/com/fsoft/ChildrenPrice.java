package vn.com.fsoft;

public class ChildrenPrice extends Price{
	public double getPrice(int rentedDays) {
		if (rentedDays > 3) {
			return 1.5 + (rentedDays - 3) * 1.5;
		}
		return 1.5;
	}

	@Override
	int getFrequentPoints(int rentedDays) {
		return 1;
	}
}
