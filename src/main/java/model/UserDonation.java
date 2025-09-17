package model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDonation {
    private int id;
    private LocalDateTime created;
    private String name;
    private String text;
    private int money;
    private Donation donation;
    private User user;
    
//    private int status;
    public UserDonation() {}
    
	public UserDonation(String name, String text, int money, Donation donation, User user) {

		this.name = name;
		this.text = text;
		this.money = money;
		this.donation = donation;
		this.user = user;
	}

	public UserDonation(int id, LocalDateTime created ,String name, String text, int money, Donation donation, User user) {
		this.id = id;
		this.created = created;
		this.name = name;
		this.text = text;
		this.money = money;
		this.donation = donation;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
