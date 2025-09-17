package model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String password;
    private String userName;
    private Role role;
    private String address;
    private String fullName;
    private String phoneNumber;
    private String note;
    private LocalDateTime created;
    private int status;
    
//    private List<UserDonation> userDonation;
    
    public User() {}
    
	public User(int id) {
		this.id = id;
	}

	public User(int id, String email, String password, String userName, Role role, String address, String fullName,
			String phoneNumber, String note, LocalDateTime created, int status) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.role = role;
		this.address = address;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.created = created;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", userName=" + userName + ", roleId="
				+ role + ", address=" + address + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
				+ ", note=" + note + ", created=" + created + ", status=" + status + "]";
	}
	
}
