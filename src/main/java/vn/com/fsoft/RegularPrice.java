package vn.com.fsoft;

public class RegularPrice extends Price {
	public double getPrice(int rentedDays) {
		if (rentedDays > 2) {
			return 2 + (rentedDays - 2) * 1.5;
		}
		return 2;
	}

	@Override
	int getFrequentPoints(int rentedDays) {
		return 1;
	}
}
