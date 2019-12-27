package com.collabera.todoapp.model;
import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
public class Todo {
	private int id;
	//which should take more than 5 characters
	@Size(min=5, message = "Description field should contain 5 or more characters")
	private String desc;
	private String user;
	@FutureOrPresent(message="Date should be greater than today")
	private Date targetDate;
	private boolean status;
	public Todo(){
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", Desc=" + desc + ", user=" + user + ", targetDate=" + targetDate + ", status="
				+ status + "]";
	}
	public Todo(int id, String desc, String user, Date targetDate, boolean status) {
		super();
		this.id = id;
		this.desc = desc;
		this.user = user;
		this.targetDate = targetDate;
		this.status = status;
	}
}