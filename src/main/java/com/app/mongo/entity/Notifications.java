package com.app.mongo.entity;

public class Notifications {

	private Integer id;
	private String name;
	private String status;
	private Integer notificationDate;
	private String desc;

	public Notifications() {
		
	}
	public Notifications(Integer id, String name, String status, Integer notificationDate, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.notificationDate = notificationDate;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Integer notificationDate) {
		this.notificationDate = notificationDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
