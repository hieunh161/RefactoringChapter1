package vn.com.fsoft;

public class InvalidPrice extends Price {

	@Override
	double getPrice(int rentedDays) {
		return 0;
	}

	@Override
	int getFrequentPoints(int rentedDays) {
		return 1;
	}

}
