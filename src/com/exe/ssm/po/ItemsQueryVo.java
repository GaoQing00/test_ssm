package com.exe.ssm.po;

import java.util.List;

/**
 * 商品包装对象 
 */
//尽量不要用继承方式，不好扩展，建议使用组合类型。
//public class ItemsQueryVo extends ... {
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	//批量商品信息
	private List<ItemsCustom> itemsList;
	
	//用户信息
	//private User user;
	//一般用扩展类
	//private UserCustom userCustom;

	public Items getItems() {
		return items;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
}
