package com.ebrightmoon.bean;

public class UserInfo {

	private String name;
	private String age;
	private String des;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", des=" + des + "]";
	}

}
