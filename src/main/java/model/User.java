package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
//    private String address;
//    private String fullName;
//    private String note;
//    private String phoneNumber;
//    private int status;
//    private String created;
    private int id;
    private String email;
    private String password;
    private String userName;

    private Role role;
//    private List<UserDonation> userDonation;
    
    public User() {}
    
    public User(int id, String email, String password, String userName, Role role) {
    	super();
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.userName = userName;
    	this.role = role;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
