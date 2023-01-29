package proxy;

import java.sql.SQLException;
import java.util.Vector;

import facade.BertaniFacade;
import facade.Helper;
import model.User;

public class Repository {

	private static Repository instance;

	private Repository() {

	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}

	Helper helper = Helper.getInstance();

	// Query for User

	public Vector<User> getUser(Vector<User> user) {
		user.clear();
		Connect con = Connect.getConnection();

		try {
			String query = "SELECT id, season_id, name, email, password, money, day, year\n" + "FROM msuser u\n"
					+ "LEFT JOIN mscropstorage cs ON cs.id = u.crop_storage_id\n"
					+ "LEFT JOIN msseedstorage ss ON ss.id = u.seed_storage_id\n"
					+ "LEFT JOIN msseason s ON s.id = u.season_id";
			var res = con.executeQuery(query);
			int id, seasonId, money, day, year;
			String name, email, password;

			while (res.next()) {
				id = res.getInt("id");
				seasonId = res.getInt("season_id");
				name = res.getString("name");
				email = res.getString("email");
				password = res.getString("password");
				money = res.getInt("money");
				day = res.getInt("day");
				year = res.getInt("year");
				user.add(new User(id, seasonId, name, email, password, money, day, year));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return user;
	}

	public void checkUser(String email, String password) {
		Connect con = Connect.getConnection();

		try {
			if (email != null && password != null) {
				String query = String.format("SELECT s.name, u.name, email, password, money, day, year\n"
						+ "FROM msuser u\n" + "LEFT JOIN msseason s ON s.id = u.season_id\n"
						+ "WHERE email = '%s' AND password = '%s'", email, password);
				var res = con.executeQuery(query);
				String name, seasonName;
				int money, day, year;
				if (res.next()) {

					name = res.getString("u.name");
					seasonName = res.getString("s.name");
					money = res.getInt("money");
					day = res.getInt("day");
					year = res.getInt("year");

					System.out.println("Login successfull");
					helper.pressToContinue();
					helper.clearScreen();
					BertaniFacade test = BertaniFacade.getInstance();
					test.mainMenu(name, seasonName, money, day, year);
				} else {
					System.out.println("User not found");
					helper.pressToContinue();
					helper.clearScreen();
					BertaniFacade test = BertaniFacade.getInstance();
					test.login();
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void addUser(int seasonId, String name, String email, String password, int money, int day, int year) {
		Connect con = Connect.getConnection();
		String query = String.format("INSERT INTO msuser VALUES(DEFAULT, '%d', '%s', '%s', '%s', '%d', '%d', '%d')",
				seasonId, name, email, password, money, day, year);
		con.executeUpdate(query);
	}

	public void updateUser(int seasonId, int money, int day, int year) {
		Connect con = Connect.getConnection();
		String query = String.format("UPDATE msuser\r\n"
				+ "SET season_id = '%d', money = '%d', day = '%d', year = '%d'\r\n" + "WHERE id = '%d'", seasonId,
				money, day, year);
		con.executeUpdate(query);
	}

}
