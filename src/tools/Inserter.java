package tools;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

import dal.UserDao;
import model.User;
import servlet.listing.dao.ListingDao;

/**
 * main() runner, used for the app demo.
 * 
 * Instructions:
 * 1. Create a new MySQL schema and then run the CREATE TABLE statements from lecture:
 * http://goo.gl/86a11H.
 * 2. Update ConnectionManager with the correct user, password, and schema.
 */
public class Inserter {

	public static void main(String[] args) throws SQLException {
		// DAO instances.
		UserDao userDao = UserDao.getInstance();
		ListingDao listingDao = ListingDao.getInstance();

		// -------------------------   INSERT   ------------------------- //
		System.out.println("\n----------  Testing INSERT  ----------");
		// UserDao
		System.out.println("\nTesting UserDao INSERT...");
		User ui1 = new User("user1", "email1@gmail.com", "passwordHash1",
						"name", Instant.now(), 0, 0);
		userDao.create(ui1);
		System.out.println("Insert: " + ui1);
		User ui2 = new User("user2", "email2@gmail.com", "passwordHash2",
						"name", Instant.now(), 0, 0);
		userDao.create(ui2);
		System.out.println("Insert: " + ui2);

		// -------------------------   UPDATE   ------------------------- //
		System.out.println("\n----------  Testing UPDATE  ----------");
		// UserDao
		System.out.println("\nTesting UserDao UPDATE 'updatePassword'...");
		User uu1 = userDao.updatePassword(ui1, "passwordHash1-updated");
		System.out.println("Update: " + uu1);

		// -------------------------   READ   ------------------------- //
		System.out.println("\n----------  Testing READ  ----------");
		// UserDao
		System.out.println("\nTesting UserDao READ 'getUserById'...");
		User ur1 = userDao.getUserById("user1");
		System.out.println("Read: " + ur1);

		System.out.println("\nTesting UserDao READ 'getUsersByName'...");
		List<User> uList1 = userDao.getUsersByName("name");
		for(User u : uList1) {
			System.out.println("Loop: " + u);
		}

		// -------------------------   DELETE   ------------------------- //
		System.out.println("\n----------  Testing DELETE  ----------");
		// UserDao
		System.out.println("\nTesting UserDao DELETE...");
		User ud1 = userDao.delete(ui1);
		System.out.println("Delete: " + ud1);
		User ud2 = userDao.delete(ui2);
		System.out.println("Delete: " + ud2);

		System.out.println(
						listingDao.getListingCards(
										"luxury", null, null, null, null,
										null,null,null,6,
										null,null, null).size());
	}
}
