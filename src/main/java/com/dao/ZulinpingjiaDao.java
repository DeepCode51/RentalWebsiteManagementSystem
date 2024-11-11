package com.dao;

import com.entity.ZulinpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZulinpingjiaVO;
import com.entity.view.ZulinpingjiaView;


/**
 * 租赁评价
 * 
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
public interface ZulinpingjiaDao extends BaseMapper<ZulinpingjiaEntity> {
	
	List<ZulinpingjiaVO> selectListVO(@Param("ew") Wrapper<ZulinpingjiaEntity> wrapper);
	
	ZulinpingjiaVO selectVO(@Param("ew") Wrapper<ZulinpingjiaEntity> wrapper);
	
	List<ZulinpingjiaView> selectListView(@Param("ew") Wrapper<ZulinpingjiaEntity> wrapper);

	List<ZulinpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<ZulinpingjiaEntity> wrapper);
	
	ZulinpingjiaView selectView(@Param("ew") Wrapper<ZulinpingjiaEntity> wrapper);
	
}
