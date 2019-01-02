package com.lay.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @Component 表明会被Ioc容器扫描
 * user为Bean的名称,如果不配置默认会把类名第一个小写作为Bean名称
 * @author Lay
 */
@Component("user")
public class User {
	/**
	 * @Value 指定具体的值，然后IoC注入属性
	 */
	@Value("1")
	private Long id;
	@Value("lay")
	private String userName;
	@Value("hello scan world")
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
