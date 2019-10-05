package com.exe.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.exe.ssm.exception.CustomException;
import com.exe.ssm.mapper.ItemsMapper;
import com.exe.ssm.mapper.ItemsMapperCustom;
import com.exe.ssm.po.Items;
import com.exe.ssm.po.ItemsCustom;
import com.exe.ssm.po.ItemsQueryVo;
import com.exe.ssm.service.ItemsService;

/**
 * 商品管理
 */
public class ItemsServiceImpl implements ItemsService{
	
	//在dao里面自动扫描，且.xml和.java同名了
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//异常处理
		if(items==null){
			throw new CustomException("修改的商品信息不存在！");
		}
		//中间对商品信息进行业务处理
		//...
		//然后返回扩展类ItemsCustom
		ItemsCustom itemsCustom = null;
		//将items的属性值拷贝到itemsCustom
		if(items!=null){			
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验id是否为空，如果为空抛出异常
		
		//更新商品信息使用updateByPrimaryKeyWithBLOBs，根据id更新items表中的所有字段，包括大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

}
