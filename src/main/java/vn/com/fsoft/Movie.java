package vn.com.fsoft;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String title;
	private Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.price = createPrice(priceCode);
	}

	public String getTitle() {
		return title;
	}

	double getCharge(int rentedDays) {
		return price.getPrice(rentedDays);
	}
	
	// Switch case to inheritance, composition, strategy, state pattern...
	private Price createPrice(int priceCode) {
		Price price;
		switch (priceCode) {
		case Movie.REGULAR:
			price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			price = new ChildrenPrice();
			break;
		default:
			price = new InvalidPrice();
		}
		return price;
	}

	int getFrequentPoint(int rentedDays) {
		return price.getFrequentPoints(rentedDays);
	};
}
