package com.report.vo;

public class AgeAndSal {
	private Integer age;
	private Integer sal;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "AgeAndSal [age=" + age + ", sal=" + sal + "]";
	}
	
}
