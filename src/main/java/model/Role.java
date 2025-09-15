package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Role {
    private int id;
    private String roleName;
    public Role() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}
    
}
