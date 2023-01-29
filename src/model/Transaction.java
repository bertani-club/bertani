package model;

public class Transaction {

	private int id;
	private int userId;
	private int cropId;
	private int quantity;

	public Transaction(int id, int userId, int cropId, int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.cropId = cropId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
