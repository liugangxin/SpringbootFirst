package com.liu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AsyncBean {
	private String name;
	private String blog;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "AsyncBean [name=" + name + ", blog=" + blog + "]";
	}
}
