package enums;

public enum Message {
	MESSAGE("message"),
	STATUS("status"),
	ERROR("error");
	private final String key;

	private Message(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
