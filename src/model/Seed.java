package model;

public class Seed {

	private int id;
	private int cropId;
	private int seasonId;
	private int price;
	private int day;

	public Seed(int id, int cropId, int seasonId, int price, int day) {
		super();
		this.id = id;
		this.cropId = cropId;
		this.seasonId = seasonId;
		this.price = price;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
