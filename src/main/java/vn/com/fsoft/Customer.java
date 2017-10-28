package vn.com.fsoft;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		// HEADER
		String result = "Rental Record for " + getName() + "\n";
		// BODY
		for (Rental rental: rentals) {
			result += "\t" + rental.getMovieTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
		}
		// FOOTER
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentPoints()) + " frequent renter points";
		return result;
	}

	private int getTotalFrequentPoints() {
		int total = 0;
		for(Rental rental : rentals) {
			total += rental.getFrequentPoint();
		}
		return total;
	}

	private double getTotalCharge() {
		double total = 0;
		for(Rental rental: rentals) {
			total += rental.getCharge();
		}
		return total;
	}
}
