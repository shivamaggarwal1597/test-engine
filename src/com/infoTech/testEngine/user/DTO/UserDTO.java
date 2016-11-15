package com.infoTech.testEngine.user.DTO;

import java.io.Serializable;

public class UserDTO extends Object implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userid;
	private String password;
	private String gender;
	private String city;
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof UserDTO){
			UserDTO userDTO=(UserDTO)o;
			if(userDTO.getUserid().equals(this.getUserid())&&userDTO.getPassword().equals(this.getPassword())){
				return true;
			}
			
		}
		
		
		return false;
		
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", password=" + password + ", gender=" + gender + ", city=" + city + "]";
	}
	
}
