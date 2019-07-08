package com.revature.carappbeans;

public class User {

	public User() {
	}

	public User(int userID, String userName, String passwrd, String name, int access) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.passwrd = passwrd;
		this.name = name;
		this.access = access;
	}

	private String userName;
	private String passwrd;
	private String name;
	private int access;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passwrd=" + passwrd + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwrd == null) ? 0 : passwrd.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwrd == null) {
			if (other.passwrd != null)
				return false;
		} else if (!passwrd.equals(other.passwrd))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public int isAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

}