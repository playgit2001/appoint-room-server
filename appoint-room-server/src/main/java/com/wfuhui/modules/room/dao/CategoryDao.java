package com.wfuhui.modules.room.dao;

import com.wfuhui.modules.room.entity.CategoryEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 分类
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-07-14 13:43:12
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {

	List<CategoryEntity> queryAll();
	
}
