package model;

public class User {

	private int id;
	private int seasonId;
	private String name;
	private String email;
	private String password;
	private int money;
	private int day;
	private int year;

	public User(int id, int seasonId, String name, String email, String password, int money, int day, int year) {
		super();
		this.id = id;
		this.seasonId = seasonId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.money = money;
		this.day = day;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
