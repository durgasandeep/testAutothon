package com.epam.autothon.restassured.model;

import java.util.Objects;

public class User {
	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public String getWebsite() {
		return website;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("user[id=");
		stringBuilder.append(this.id);
		stringBuilder.append(", name=");
		stringBuilder.append(this.name);
		stringBuilder.append(", username=");
		stringBuilder.append(this.username);
		stringBuilder.append(", email=");
		stringBuilder.append(this.email);
		stringBuilder.append(", phone=");
		stringBuilder.append(this.phone);
		stringBuilder.append(", website=");
		stringBuilder.append(this.website);
		stringBuilder.append("]");
		
		return stringBuilder.toString();
		
	}	
	
	@Override
    public boolean equals(Object o) {
        
		if (o == this) 
			return true;
        
        if (!(o instanceof User)) 
            return false;
        
        User user = (User) o;
        
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(website, user.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, phone, website);
    }
}
