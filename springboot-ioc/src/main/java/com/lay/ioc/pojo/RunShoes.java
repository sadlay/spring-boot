package com.lay.ioc.pojo;

import org.springframework.stereotype.Component;

import com.lay.ioc.pojo.definiion.Shoes;

@Component
public class RunShoes implements Shoes {

	@Override
	public void put() {
		System.out.println("穿跑鞋【"+BasketShoes.class.getSimpleName()+"】去跑步");
	}
}
