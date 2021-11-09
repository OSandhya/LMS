package com.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;
	 @NotNull
	 @Column(name = "username", nullable = false)
	// @Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")	
	 private String username;
	 @NotNull
	 @Column(name = "password", nullable = false)
	// @Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Password must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")	
	private String password;
	
		@OneToOne(cascade=CascadeType.MERGE)
		private Users users;

	public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
