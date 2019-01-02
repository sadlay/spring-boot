package com.lay.ioc.pojo;

import org.springframework.stereotype.Component;

import com.lay.ioc.pojo.definiion.Shoes;
@Component
public class BasketShoes implements Shoes{

	@Override
	public void put() {
		System.out.println("穿篮球鞋【"+BasketShoes.class.getSimpleName()+"】去打球");
	}

}
