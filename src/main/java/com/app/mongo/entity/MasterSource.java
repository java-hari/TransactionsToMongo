package com.app.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "master_source")
public class MasterSource {

	@Id
	private Integer id;

	private String name;
	private String status;

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

	public MasterSource(Integer id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	

}
