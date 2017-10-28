package vn.com.fsoft;

public abstract class Price {
	abstract double getPrice(int rentedDays);
	abstract int getFrequentPoints(int rentedDays);
}
