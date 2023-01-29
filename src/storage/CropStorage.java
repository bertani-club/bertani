package storage;

public class CropStorage extends Storage {

	private int cropId;

	public CropStorage(int id, int user_id, int quantity, int cropId) {
		super(id, user_id, quantity);
		this.cropId = cropId;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

}
