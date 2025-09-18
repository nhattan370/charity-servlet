package enums;

public enum PageSize {
	SMALL(5),
	MEDIUM(10),
	LARGE(15),
	XLARGE(20);
	
	private final int size;

	private PageSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
	
}
