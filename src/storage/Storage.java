package storage;

public abstract class Storage {

	private int id;
	private int user_id;
	private int quantity;

	public Storage(int id, int user_id, int quantity) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
