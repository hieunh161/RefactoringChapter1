package vn.com.fsoft;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	double getCharge() {
		return movie.getCharge(daysRented);
	}

	int getFrequentPoint() {
		return movie.getFrequentPoint(daysRented);
	}
	
	String getMovieTitle() {
		return movie.getTitle();
	}
}
