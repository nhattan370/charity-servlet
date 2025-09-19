package dto;

public class UserDTO {
	private int userId;
	private String username;
	private String roleName;
	
	public UserDTO(int userId, String username, String roleName) {
		this.userId = userId;
		this.username = username;
		this.roleName = roleName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
