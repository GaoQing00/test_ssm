package com.exe.ssm.mapper;


import com.exe.ssm.po.ItemsCustom;
import com.exe.ssm.po.ItemsQueryVo;
import java.util.List;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}