package com.exe.ssm.service;

import java.util.List;

import com.exe.ssm.po.ItemsCustom;
import com.exe.ssm.po.ItemsQueryVo;

/**
 * 商品管理service 
 */
public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	//根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * @param id 修改商品的id
	 * @param itemsCustom 修改商品的信息
	 * @return
	 * @throws Exception
	 */
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
}
