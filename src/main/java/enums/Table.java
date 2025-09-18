package enums;

public enum Table {
	USER("user"),
	DONATION("donation"),
	ROLE("role"),
	USER_DONATION("user_donation");
	
	private final String tableName;

	private Table(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}
	
	
}
