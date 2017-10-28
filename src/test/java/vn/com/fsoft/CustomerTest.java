package vn.com.fsoft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

public class CustomerTest {
	
	private static final Movie THE_LION_KING = new Movie("The Lion King", Movie.CHILDRENS);
	private static final Movie THE_PIRATE_5 = new Movie("The pirate", Movie.REGULAR);
	private static final Movie SPIDER_MAN = new Movie("Spiderman", Movie.NEW_RELEASE);
	private static final Movie INVALID_MOVIE = new Movie("Invalid", 4);

	private final Customer customer = new Customer("HieuNH5");

	@Test
	public void basicNewReleaseRental() {
		customer.addRental(new Rental(SPIDER_MAN, 1));
		assertThat(customer.statement(), equalTo(expectedMessage("Spiderman", 3.0, 3.0, 1)));
	}
	
	@Test
	public void shouldDiscountNewReleaseRental() {
		customer.addRental(new Rental(SPIDER_MAN, 3));
		assertThat(customer.statement(), equalTo(expectedMessage("Spiderman", 9.0, 9.0, 2)));
	}

	@Test
	public void basicRegularRental() {
		customer.addRental(new Rental(THE_PIRATE_5, 1));
		assertThat(customer.statement(), equalTo(expectedMessage("The pirate", 2.0, 2.0, 1)));
	}

	@Test
	public void shouldDiscountReularRental() {
		customer.addRental(new Rental(THE_PIRATE_5, 4));
		assertThat(customer.statement(), equalTo(expectedMessage("The pirate", 5, 5, 1)));
	}
	
	@Test
	public void basicChildrenRental() {
		customer.addRental(new Rental(THE_LION_KING, 2));
		assertThat(customer.statement(), equalTo(expectedMessage("The Lion King", 1.5, 1.5, 1)));
	}
	
	@Test
	public void shouldDiscountChildrenRental() {
		customer.addRental(new Rental(THE_LION_KING, 5));
		assertThat(customer.statement(), equalTo(expectedMessage("The Lion King", 4.5, 4.5, 1)));
	}
	
	@Test
	public void invalidRental() {
		customer.addRental(new Rental(INVALID_MOVIE, 5));
		assertThat(customer.statement(), equalTo(expectedMessage("Invalid", 0.0, 0.0, 1)));
	}

	private String expectedMessage(String rental, double price, double amount, int frequentPoints) {
		return String.format(
				"Rental Record for HieuNH5\n	%s	%s\nAmount owed is %s\nYou earned %d frequent renter points",
				rental, price, amount, frequentPoints);
	}
}
