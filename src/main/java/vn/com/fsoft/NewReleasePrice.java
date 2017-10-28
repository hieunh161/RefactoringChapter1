package vn.com.fsoft;

public class NewReleasePrice extends Price {
	public double getPrice(int rentedDays) {
		return rentedDays * 3;
	}

	@Override
	int getFrequentPoints(int rentedDays) {
		return rentedDays > 1 ? 2 : 1;
	}
}
