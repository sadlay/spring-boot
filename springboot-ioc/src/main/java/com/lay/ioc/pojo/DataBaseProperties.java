package com.lay.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class DataBaseProperties {

	@Value("${test.driverName}")
	private String driverName = null;

	@Value("${test.url}")
	private String url = null;

	private String username = null;

	private String password = null;

	public void setDriverName(String driverName) {
		System.out.println(driverName);
		this.driverName = driverName;
	}

	public void setUrl(String url) {
		System.out.println(url);
		this.url = url;
	}

	@Value("${test.username}")
	public void setUsername(String username) {
		System.out.println(username);
		this.username = username;
	}

	@Value("${test.password}")
	public void setPassword( String password) {
		System.out.println(password);
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
