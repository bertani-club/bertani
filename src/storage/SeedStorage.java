package storage;

public class SeedStorage extends Storage {

	private int seedId;

	public SeedStorage(int id, int user_id, int quantity, int seedId) {
		super(id, user_id, quantity);
		this.seedId = seedId;
	}

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

}
