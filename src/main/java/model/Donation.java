package model;

import java.util.List;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
public class Donation {
    private int id;
//    private String code;
//    private String created;
    private String description;
    private String endDate;
    private int money;
    private String name;
    private String organizationName;
    private String phoneNumber;
    private String startDate;
    private int status;
    private List<UserDonation> userDonations;
    
    
    
	public Donation(int id, String description, String endDate, int money, String name, String organizationName,
			String phoneNumber, String startDate, int status, List<UserDonation> userDonations) {
		this.id = id;
		this.description = description;
		this.endDate = endDate;
		this.money = money;
		this.name = name;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.status = status;
		this.userDonations = userDonations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<UserDonation> getUserDonations() {
		return userDonations;
	}
	public void setUserDonations(List<UserDonation> userDonations) {
		this.userDonations = userDonations;
	}
    
}
